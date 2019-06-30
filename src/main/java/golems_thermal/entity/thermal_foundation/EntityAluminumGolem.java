package golems_thermal.entity.thermal_foundation;

import com.golems.main.GolemItems;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.World;

public class EntityAluminumGolem extends ThermalGolemColorized {

	public EntityAluminumGolem(World world) {
		super(world, 0x00D8D9E3, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.ALUMINUM_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.ALUMINUM)));
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
			final BlockStorage.Type type = body.getValue(BlockStorage.VARIANT);
			switch(type) {
			case ALUMINUM:
				break;
			case COPPER:
				replace(this, new EntityCopperGolem(this.getEntityWorld()));
				break;
			case IRIDIUM:
				replace(this, new EntityIridiumGolem(this.getEntityWorld()));
				break;
			case LEAD:
				replace(this, new EntityLeadGolem(this.getEntityWorld()));
				break;
			case MITHRIL:
				replace(this, new EntityManaInfusedGolem(this.getEntityWorld()));
				break;
			case NICKEL:
				replace(this, new EntityNickelGolem(this.getEntityWorld()));
				break;
			case PLATINUM:
				replace(this, new EntityPlatinumGolem(this.getEntityWorld()));
				break;
			case SILVER:
				replace(this, new EntitySilverGolem(this.getEntityWorld()));
				break;
			case TIN:
				replace(this, new EntityTinGolem(this.getEntityWorld()));
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
