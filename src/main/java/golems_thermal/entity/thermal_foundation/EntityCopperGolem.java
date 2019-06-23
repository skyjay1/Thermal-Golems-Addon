package golems_thermal.entity.thermal_foundation;

import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityCopperGolem extends ThermalGolemColorized {

	public EntityCopperGolem(World world) {
		super(world, 0xD48040, true);
	}
//
//	@Override
//	protected ResourceLocation applyTexture() {
//		return makeTexture(ThermalGolems.MODID, ThermalGolemNames.COPPER_GOLEM);
//	}

}
