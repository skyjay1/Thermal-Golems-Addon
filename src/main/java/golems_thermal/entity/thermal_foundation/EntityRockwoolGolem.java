package golems_thermal.entity.thermal_foundation;

import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityRockwoolGolem extends ThermalGolemTextured {

	public EntityRockwoolGolem(World world) {
		super(world);
	}

	@Override
	protected ResourceLocation applyTexture() {
		// TODO actually make the texture
		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.ROCKWOOL_GOLEM);
	}
}
