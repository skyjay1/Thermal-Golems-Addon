package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityCopperGolem extends ThermalGolemColorized {

	public EntityCopperGolem(World world) {
		super(world, 0xD48040, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.COPPER_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.COPPER)));
	}
}
