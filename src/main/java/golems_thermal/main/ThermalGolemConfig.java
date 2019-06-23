package golems_thermal.main;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;

import golems_thermal.entity.thermal_foundation.EntityCopperGolem;
import net.minecraftforge.common.config.Configuration;

public class ThermalGolemConfig {

	
	public static void initGolemConfigSets(final Configuration config) {
		config.load();
		
		GolemLookup.addConfig(EntityCopperGolem.class, new GolemConfigSet(config, "Copper Golem", 60.0D, 8.0F));
		
		
		config.save();
	}
}
