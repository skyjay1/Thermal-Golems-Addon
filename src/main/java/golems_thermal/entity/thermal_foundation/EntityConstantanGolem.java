package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityConstantanGolem extends ThermalGolemColorized {

	public EntityConstantanGolem(World world) {
		super(world, 0x00E1B670, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.CONSTANTAN_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorageAlloy.getDefaultState()
				.withProperty(BlockStorageAlloy.VARIANT, BlockStorageAlloy.Type.CONSTANTAN)));
	}
}
