package golems_thermal.entity.thermal_foundation;

import cofh.thermalfoundation.block.BlockStorage;
import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySilverGolem extends ThermalGolemTextured {

	public EntitySilverGolem(World world) {
		super(world);
		this.setLootTableLoc(ThermalGolems.MODID, ThermalGolemNames.SILVER_GOLEM);
		this.setCreativeReturn(ThermalGolemColorized.getStack(TFBlocks.blockStorage.getDefaultState()
				.withProperty(BlockStorage.VARIANT, BlockStorage.Type.SILVER)));
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.SILVER_GOLEM);
	}
}
