package golems_thermal.main;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;

import golems_thermal.entity.thermal_foundation.*;
import net.minecraftforge.common.config.Configuration;

public class ThermalGolemConfig {

	
	public static void initGolemConfigSets(final Configuration config) {
		config.load();
		
		GolemLookup.addConfig(EntityAluminumGolem.class, new GolemConfigSet(config, "Aluminum Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityBronzeGolem.class, new GolemConfigSet(config, "Bronze Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityCoalCokeGolem.class, new GolemConfigSet(config, "Coal-Coke Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityConstantanGolem.class, new GolemConfigSet(config, "Constantan Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityCopperGolem.class, new GolemConfigSet(config, "Copper Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityElectrumGolem.class, new GolemConfigSet(config, "Electrum Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityEnderiumGolem.class, new GolemConfigSet(config, "Enderium Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityHardGlassGolem.class, new GolemConfigSet(config, "Hard Glass Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityInvarGolem.class, new GolemConfigSet(config, "Invar Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityIridiumGolem.class, new GolemConfigSet(config, "Iridium Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityLeadGolem.class, new GolemConfigSet(config, "Lead Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityLumiumGolem.class, new GolemConfigSet(config, "Lumium Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityManaInfusedGolem.class, new GolemConfigSet(config, "Mana-Infused Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityNickelGolem.class, new GolemConfigSet(config, "Nickel Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityPlatinumGolem.class, new GolemConfigSet(config, "Platinum Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityRockwoolGolem.class, new GolemConfigSet(config, "Rockwool Golem", 50.0D, 6.0F));
		GolemLookup.addConfig(EntitySignalumGolem.class, new GolemConfigSet(config, "Signalum Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntitySilverGolem.class, new GolemConfigSet(config, "Silver Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntitySteelGolem.class, new GolemConfigSet(config, "Steel Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityTinGolem.class, new GolemConfigSet(config, "Tin Golem", 60.0D, 8.0F));		
		
		config.save();
	}
}
