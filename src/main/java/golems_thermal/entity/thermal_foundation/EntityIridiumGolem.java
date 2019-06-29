package golems_thermal.entity.thermal_foundation;

import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityIridiumGolem extends ThermalGolemTextured {

	public EntityIridiumGolem(World world) {
		super(world);
	}

	@Override
	protected ResourceLocation applyTexture() {
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.IRIDIUM_GOLEM);
	}
}
