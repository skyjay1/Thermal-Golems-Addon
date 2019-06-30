package golems_thermal.main;

import com.golems.util.GolemConfigSet;
import com.golems.util.GolemLookup;

import golems_thermal.entity.thermal_foundation.*;
import net.minecraftforge.common.config.Configuration;

public final class ThermalGolemConfig {
	
	private ThermalGolemConfig() {}
	
	public static void initGolemConfigSets(final Configuration config) {
		config.load();
		
		GolemLookup.addConfig(EntityAluminumGolem.class, new GolemConfigSet(config, "Aluminum Golem", 80.0D, 4.0F));
		GolemLookup.addConfig(EntityBronzeGolem.class, new GolemConfigSet(config, "Bronze Golem", 94.0D, 6.2F));
		GolemLookup.addConfig(EntityCoalCokeGolem.class, new GolemConfigSet(config, "Coal-Coke Golem", 24.0D, 2.5F));
		GolemLookup.addConfig(EntityConstantanGolem.class, new GolemConfigSet(config, "Constantan Golem", 86.0D, 5.2F));
		GolemLookup.addConfig(EntityCopperGolem.class, new GolemConfigSet(config, "Copper Golem", 72.0D, 5.4F));
		GolemLookup.addConfig(EntityElectrumGolem.class, new GolemConfigSet(config, "Electrum Golem", 78.0D, 2.5F)
				.addKey(EntityElectrumGolem.ALLOW_IMMUNE, true, "Whether this golem is immune to magic damage"));
		GolemLookup.addConfig(EntityEnderiumGolem.class, new GolemConfigSet(config, "Enderium Golem", 134.0D, 8.0F)
				.addKey(EntityEnderiumGolem.ALLOW_SPECIAL, true, "Whether this golem can teleport"));
		GolemLookup.addConfig(EntityHardGlassGolem.class, new GolemConfigSet(config, "Hard Glass Golem", 32.0D, 11.5F));
		GolemLookup.addConfig(EntityInvarGolem.class, new GolemConfigSet(config, "Invar Golem", 88.0D, 7.5F));
		GolemLookup.addConfig(EntityIridiumGolem.class, new GolemConfigSet(config, "Iridium Golem", 122.0D, 5.9F));
		GolemLookup.addConfig(EntityLeadGolem.class, new GolemConfigSet(config, "Lead Golem", 56.0D, 3.8F));
		GolemLookup.addConfig(EntityLumiumGolem.class, new GolemConfigSet(config, "Lumium Golem", 100.0D, 6.8F)
				.addKey(EntityLumiumGolem.ALLOW_SPECIAL, true, "Whether the golem provides light")
				.addKey(EntityLumiumGolem.FREQUENCY, 2, 1, 24000, "Frequency of light-updates in ticks"));
		GolemLookup.addConfig(EntityManaInfusedGolem.class, new GolemConfigSet(config, "Mana-Infused Golem", 158.0D, 5.2F)
				.addKey(EntityManaInfusedGolem.DAMAGE_UNDEAD, true, "Whether this golem deals extra damage to undead mobs")
				.addKey(EntityManaInfusedGolem.ALLOW_SPECIAL, true, "Whether the golem provides faint light")
				.addKey(EntityManaInfusedGolem.FREQUENCY, 2, 1, 24000, "Frequency of light-updates in ticks"));
		GolemLookup.addConfig(EntityNickelGolem.class, new GolemConfigSet(config, "Nickel Golem", 82.0D, 5.9F));
		GolemLookup.addConfig(EntityPlatinumGolem.class, new GolemConfigSet(config, "Platinum Golem", 200.0D, 22.0F));
		GolemLookup.addConfig(EntityRockwoolGolem.class, new GolemConfigSet(config, "Rockwool Golem", 28.0D, 2.2F));
		GolemLookup.addConfig(EntitySignalumGolem.class, new GolemConfigSet(config, "Signalum Golem", 114.0D, 6.0F));
		GolemLookup.addConfig(EntitySilverGolem.class, new GolemConfigSet(config, "Silver Golem", 64.0D, 5.0F)
				.addKey(EntitySilverGolem.ALLOW_IMMUNE, true, "Whether this golem is immune to magic damage"));
		GolemLookup.addConfig(EntitySteelGolem.class, new GolemConfigSet(config, "Steel Golem", 138.0D, 6.6F));
		GolemLookup.addConfig(EntityTinGolem.class, new GolemConfigSet(config, "Tin Golem", 76.0D, 4.9F));		
		
		config.save();
	}
}
