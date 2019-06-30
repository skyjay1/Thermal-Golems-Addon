package golems_thermal.entity.thermal_foundation;

import com.golems.main.GolemItems;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class EntityBronzeGolem extends ThermalGolemColorized {

	public EntityBronzeGolem(World world) {
		super(world, 0x00EEA95A, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.BRONZE_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorageAlloy.getDefaultState()
				.withProperty(BlockStorageAlloy.VARIANT, BlockStorageAlloy.Type.BRONZE)));
	}
	
	/** 
	 * Called after golem has been spawned. Parameters are the exact IBlockStates used to
	 * make this golem (especially used with multi-textured golems)
	 **/
	@Override
	public void onBuilt(final IBlockState body, final IBlockState legs, final IBlockState arm1, final IBlockState arm2) { 
		// make sure all blocks are the same
		boolean shouldContinue = doPropsMatch(body, legs, arm1, arm2);
		
		// if it passed the test
		if(shouldContinue) {
			// determine which metal block this is and spawn the correct golem
			final BlockStorageAlloy.Type type = body.getValue(BlockStorageAlloy.VARIANT);
			switch(type) {
			case BRONZE:
				break;
			case CONSTANTAN:
				replace(this, new EntityConstantanGolem(this.getEntityWorld()));
				break;
			case ELECTRUM:
				replace(this, new EntityElectrumGolem(this.getEntityWorld()));
				break;
			case ENDERIUM:
				replace(this, new EntityEnderiumGolem(this.getEntityWorld()));
				break;
			case INVAR:
				replace(this, new EntityInvarGolem(this.getEntityWorld()));
				break;
			case LUMIUM:
				replace(this, new EntityLumiumGolem(this.getEntityWorld()));
				break;
			case SIGNALUM:
				replace(this, new EntitySignalumGolem(this.getEntityWorld()));
				break;
			case STEEL:
				replace(this, new EntitySteelGolem(this.getEntityWorld()));
				break;
			default: 
				shouldContinue = false;
				break;
			}
		}
		
		// if it did not pass all tests
		if(!shouldContinue) {
			// drop these blocks and kill the golem
			dropAsItems(this, body, legs, arm1, arm2, GolemItems.golemHead.getDefaultState());
			this.setDead();
		}
	}
}
