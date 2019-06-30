package golems_thermal.entity.thermal_foundation;

import com.golems.entity.GolemColorizedMultiTextured;

import cofh.thermalfoundation.block.BlockRockwool;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityRockwoolGolem extends GolemColorizedMultiTextured {

	private static final ResourceLocation TEXTURE_BASE = makeTexture(ThermalGolems.MODID, "golem_thermal_base");
	private static final ResourceLocation TEXTURE_OVERLAY = makeTexture(ThermalGolems.MODID, ThermalGolemNames.ROCKWOOL_GOLEM);
	public static final int[] COLOR_ARRAY = ItemDye.DYE_COLORS;

	public EntityRockwoolGolem(World world) {
		super(world, TEXTURE_BASE, TEXTURE_OVERLAY, COLOR_ARRAY);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.26D);
	}
	
	@Override
	public SoundEvent getGolemSound() {
		return SoundEvents.BLOCK_STONE_STEP;
	}	
	
	/** 
	 * Called after golem has been spawned. Parameters are the exact IBlockStates used to
	 * make this golem (especially used with multi-textured golems)
	 **/
	@Override
	public void onBuilt(final IBlockState body, final IBlockState legs, final IBlockState arm1, final IBlockState arm2) { 
		if(body.getPropertyKeys().contains(BlockRockwool.VARIANT)) {
			this.setTextureNum((byte)body.getValue(BlockRockwool.VARIANT).getMetadata());
		}
	}
	
	@Override
	public boolean processInteract(final EntityPlayer player, final EnumHand hand) {
		final ItemStack stack = player.getHeldItem(hand);
		// only change texture when player has empty hand
		// ANOTHER FIX WE MISSED:  checking #doesInteractChangeTexture
		if (!stack.isEmpty() || !this.doesInteractChangeTexture()) {
			return false;
		} else {
			int incremented = ((this.getTextureNum() + 1) % this.colors.length);
			this.setTextureNum((byte) incremented);
			this.updateTextureByData(this.getTextureNum());
			this.writeEntityToNBT(this.getEntityData());
			player.swingArm(hand);
			return true;
		}
	}
	
	@Override
	public String getModId() {
		return ThermalGolems.MODID;
	}
}
