package golems_thermal.entity.thermal_foundation;

import golems_thermal.entity.ThermalGolemColorized;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.ThermalGolemTextured;
import golems_thermal.main.ThermalGolems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySteelGolem extends ThermalGolemColorized {

	public EntitySteelGolem(World world) {
		super(world, 0x01999999, true);
	}
}
