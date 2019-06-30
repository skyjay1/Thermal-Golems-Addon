package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityPlatinumGolem extends ThermalGolemTextured {

	public EntityPlatinumGolem(World world) {
		super(world);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.PLATINUM_GOLEM);
		this.setCreativeReturn(ThermalGolemColorized.getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.PLATINUM)));
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.PLATINUM_GOLEM);
	}
}
