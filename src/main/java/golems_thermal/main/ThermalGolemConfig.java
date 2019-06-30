package golems_thermal.main;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;

import golems_thermal.entity.thermal_foundation.*;
import net.minecraftforge.common.config.Configuration;

public final class ThermalGolemConfig {
	
	private ThermalGolemConfig() {}
	
	public static void initGolemConfigSets(final Configuration config) {
		config.load();
		
		GolemLookup.addConfig(EntityAluminumGolem.class, new GolemConfigSet(config, "Aluminum Golem", 70.0D, 4.0F));
		GolemLookup.addConfig(EntityBronzeGolem.class, new GolemConfigSet(config, "Bronze Golem", 74.0D, 7.2F));
		// COAL COKE TODO
		GolemLookup.addConfig(EntityCoalCokeGolem.class, new GolemConfigSet(config, "Coal-Coke Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityConstantanGolem.class, new GolemConfigSet(config, "Constantan Golem", 66.0D, 5.2F));
		GolemLookup.addConfig(EntityCopperGolem.class, new GolemConfigSet(config, "Copper Golem", 62.0D, 5.4F));
		GolemLookup.addConfig(EntityElectrumGolem.class, new GolemConfigSet(config, "Electrum Golem", 58.0D, 2.5F));
		// ENDERIUM TODO
		GolemLookup.addConfig(EntityEnderiumGolem.class, new GolemConfigSet(config, "Enderium Golem", 60.0D, 8.0F));
		// HARD GLASS TODO
		GolemLookup.addConfig(EntityHardGlassGolem.class, new GolemConfigSet(config, "Hard Glass Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityInvarGolem.class, new GolemConfigSet(config, "Invar Golem", 78.0D, 7.5F));
		// IRIDIUM TODO
		GolemLookup.addConfig(EntityIridiumGolem.class, new GolemConfigSet(config, "Iridium Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntityLeadGolem.class, new GolemConfigSet(config, "Lead Golem", 56.0D, 6.0F));
		// LUMIUM TODO
		GolemLookup.addConfig(EntityLumiumGolem.class, new GolemConfigSet(config, "Lumium Golem", 60.0D, 8.0F)
				.addKey(EntityLumiumGolem.ALLOW_SPECIAL, true, "Whether the golem provides light")
				.addKey(EntityLumiumGolem.FREQUENCY, 2, 1, 24000, "Frequency of light-updates in ticks"));
		// MANA-INFUSED TODO
		GolemLookup.addConfig(EntityManaInfusedGolem.class, new GolemConfigSet(config, "Mana-Infused Golem", 60.0D, 8.0F)
				.addKey(EntityManaInfusedGolem.ALLOW_SPECIAL, true, "Whether the golem provides faint light")
				.addKey(EntityManaInfusedGolem.FREQUENCY, 2, 1, 24000, "Frequency of light-updates in ticks"));
		GolemLookup.addConfig(EntityNickelGolem.class, new GolemConfigSet(config, "Nickel Golem", 72.0D, 5.9F));
		GolemLookup.addConfig(EntityPlatinumGolem.class, new GolemConfigSet(config, "Platinum Golem", 204.0D, 22.5F));
		// ROCKWOOL TODO
		GolemLookup.addConfig(EntityRockwoolGolem.class, new GolemConfigSet(config, "Rockwool Golem", 50.0D, 6.0F));
		// SIGNALUM TODO
		GolemLookup.addConfig(EntitySignalumGolem.class, new GolemConfigSet(config, "Signalum Golem", 60.0D, 8.0F));
		GolemLookup.addConfig(EntitySilverGolem.class, new GolemConfigSet(config, "Silver Golem", 44.0D, 5.0F));
		GolemLookup.addConfig(EntitySteelGolem.class, new GolemConfigSet(config, "Steel Golem", 80.0D, 7.5F));
		GolemLookup.addConfig(EntityTinGolem.class, new GolemConfigSet(config, "Tin Golem", 62.0D, 4.9F));		
		
		config.save();
	}
}
