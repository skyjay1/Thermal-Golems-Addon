package golems_thermal.entity.thermal_foundation;

import com.golems.entity.GolemColorizedMultiTextured;
import com.golems.entity.GolemMultiTextured;

import cofh.thermalfoundation.block.BlockRockwool;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemDye;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
			
//			switch(body.getValue(BlockRockwool.VARIANT)) {
//			case BLACK:		this.setTextureNum((byte)15); break;
//			case RED:		this.setTextureNum((byte)14); break;
//			case GREEN:		this.setTextureNum((byte)13); break;
//			case BROWN:		this.setTextureNum((byte)12); break;
//			case BLUE:		this.setTextureNum((byte)11); break;
//			case PURPLE:	this.setTextureNum((byte)10); break;
//			case CYAN:		this.setTextureNum((byte)9); break;
//			case SILVER:	this.setTextureNum((byte)8); break;
//			case GRAY:		this.setTextureNum((byte)7); break;
//			case PINK:		this.setTextureNum((byte)6); break;
//			case LIME:		this.setTextureNum((byte)5); break;
//			case YELLOW:	this.setTextureNum((byte)4); break;
//			case LIGHT_BLUE:this.setTextureNum((byte)3); break;
//			case MAGENTA:	this.setTextureNum((byte)2); break;
//			case ORANGE:	this.setTextureNum((byte)1); break;
//			case WHITE:		this.setTextureNum((byte)0); break;
//			default:
//				break;
//			
//			}
		}
	}
}
