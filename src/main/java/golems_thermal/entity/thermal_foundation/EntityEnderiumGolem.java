package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityEnderiumGolem extends ThermalGolemColorized {

	public EntityEnderiumGolem(World world) {
		super(world, 0x3A9D9D, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.ENDERIUM_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorageAlloy.getDefaultState()
				.withProperty(BlockStorageAlloy.VARIANT, BlockStorageAlloy.Type.ENDERIUM)));
	}
}
