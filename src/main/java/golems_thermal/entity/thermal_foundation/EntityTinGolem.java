package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityTinGolem extends ThermalGolemColorized {

	public EntityTinGolem(World world) {
		super(world, 0x98AEB9, false);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.TIN_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.TIN)));
	}
}
