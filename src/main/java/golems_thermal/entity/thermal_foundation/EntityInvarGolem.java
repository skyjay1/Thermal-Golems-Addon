package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorageAlloy;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityInvarGolem extends ThermalGolemColorized {

	public EntityInvarGolem(World world) {
		super(world, 0xB1B8B4, true);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.INVAR_GOLEM);
		this.setCreativeReturn(getStack(TFBlocks.blockStorageAlloy.getDefaultState()
				.withProperty(BlockStorageAlloy.VARIANT, BlockStorageAlloy.Type.INVAR)));
	}
}
