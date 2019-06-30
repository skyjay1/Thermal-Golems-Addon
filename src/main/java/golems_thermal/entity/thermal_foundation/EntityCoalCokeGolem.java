package golems_thermal.entity.thermal_foundation;

import com.golems.entity.EntityCoalGolem;
import com.golems.main.GolemItems;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.block.BlockStorageResource;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityCoalCokeGolem extends ThermalGolemTextured {

	public EntityCoalCokeGolem(World world) {
		super(world);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.COALCOKE_GOLEM);
		this.setCreativeReturn(ThermalGolemColorized.getStack(TFBlocks.blockStorageResource.getDefaultState()
				.withProperty(BlockStorageResource.VARIANT, BlockStorageResource.Type.COKE)));
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.COALCOKE_GOLEM);
	}
	
	/** 
	 * Called after golem has been spawned. Parameters are the exact IBlockStates used to
	 * make this golem (especially used with multi-textured golems)
	 **/
	@Override
	public void onBuilt(final IBlockState body, final IBlockState legs, final IBlockState arm1, final IBlockState arm2) { 
		// make sure all blocks are the same
		boolean shouldContinue = ThermalGolemColorized.doPropsMatch(body, legs, arm1, arm2);
		
		// if it passed the test
		if(shouldContinue) {
			// determine which metal block this is and spawn the correct golem
			final BlockStorageResource.Type type = body.getValue(BlockStorageResource.VARIANT);
			switch(type) {
			case COKE:
				break;
			case CHARCOAL:
				ThermalGolemColorized.replace(this, new EntityCoalGolem(this.getEntityWorld()));
				break;
			default: 
				shouldContinue = false;
				break;
			}
		}
		
		// if it did not pass all tests
		if(!shouldContinue) {
			// drop these blocks and kill the golem
			ThermalGolemColorized.dropAsItems(this, body, legs, arm1, arm2, GolemItems.golemHead.getDefaultState());
			this.setDead();
		}
	}
}
