package golems_thermal.entity.thermal_foundation;

import java.util.List;

import com.golems.blocks.BlockUtilityGlow;
import com.golems.entity.ai.EntityAIUtilityBlock;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityManaInfusedGolem extends ThermalGolemColorized {
	
	public static final String ALLOW_SPECIAL = "Allow Special: Emit Light";
	public static final String FREQUENCY = "Light Frequency";
	public static final String DAMAGE_UNDEAD = "Allow Special: Damage Undead";

	public EntityManaInfusedGolem(World world) {
		super(world, 0x6499BA, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.MANAINFUSED_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.MITHRIL)));
		final boolean allowed = getConfig(this).getBoolean(ALLOW_SPECIAL);
		final int freq = getConfig(this).getInt(FREQUENCY);
		final IBlockState state = ThermalGolems.blockGlowFixed.getDefaultState().withProperty(BlockUtilityGlow.LIGHT_LEVEL, 7);
		this.tasks.addTask(9, new EntityAIUtilityBlock(this, state, freq, allowed));
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity) {
		if(super.attackEntityAsMob(entity)) {
			if(getConfig(this).getBoolean(DAMAGE_UNDEAD) && entity instanceof EntityLivingBase 
					&& ((EntityLivingBase)entity).getCreatureAttribute() == EnumCreatureAttribute.UNDEAD) {
				float damage = (float)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue() * 1.85F;
				entity.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			return true;
		}
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getBrightnessForRender() {
		return (int) (15728880F * 0.9F);
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness() {
		return 0.9F;
	}
	
	@Override
	public boolean isProvidingLight() {
		return true;
	}
	
	@Override
    public List<String> addSpecialDesc(final List<String> list) {
		if(getConfig(this).getBoolean(DAMAGE_UNDEAD)) {
			String sDamage = TextFormatting.AQUA + trans("entitytip.extra_damage_undead");
			list.add(sDamage);
		}
		list.add(TextFormatting.RED + trans("entitytip.lights_area"));
		return list;
	}
}
