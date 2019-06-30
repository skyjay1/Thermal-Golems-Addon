package golems_thermal.proxy;

import com.golems.entity.GolemBase;
import com.golems.util.GolemLookup;

import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.block.BlockUtilityFixed;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.thermal_foundation.EntityAluminumGolem;
import golems_thermal.entity.thermal_foundation.EntityBronzeGolem;
import golems_thermal.entity.thermal_foundation.EntityCoalCokeGolem;
import golems_thermal.entity.thermal_foundation.EntityConstantanGolem;
import golems_thermal.entity.thermal_foundation.EntityCopperGolem;
import golems_thermal.entity.thermal_foundation.EntityElectrumGolem;
import golems_thermal.entity.thermal_foundation.EntityEnderiumGolem;
import golems_thermal.entity.thermal_foundation.EntityHardGlassGolem;
import golems_thermal.entity.thermal_foundation.EntityInvarGolem;
import golems_thermal.entity.thermal_foundation.EntityIridiumGolem;
import golems_thermal.entity.thermal_foundation.EntityLeadGolem;
import golems_thermal.entity.thermal_foundation.EntityLumiumGolem;
import golems_thermal.entity.thermal_foundation.EntityManaInfusedGolem;
import golems_thermal.entity.thermal_foundation.EntityNickelGolem;
import golems_thermal.entity.thermal_foundation.EntityPlatinumGolem;
import golems_thermal.entity.thermal_foundation.EntityRockwoolGolem;
import golems_thermal.entity.thermal_foundation.EntitySignalumGolem;
import golems_thermal.entity.thermal_foundation.EntitySilverGolem;
import golems_thermal.entity.thermal_foundation.EntitySteelGolem;
import golems_thermal.entity.thermal_foundation.EntityTinGolem;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	private static int entityCount = 0;
	
	private static EntityEntry build(final Class<? extends GolemBase> entityClass, final String name, Block... blocks) {
		// register block(s) with GolemLookup
		GolemLookup.addGolem(entityClass, blocks);
		// build an EntityEntry to return
		EntityEntryBuilder builder = EntityEntryBuilder.<GolemBase>create();
		builder.entity(entityClass);
		builder.name(ThermalGolems.MODID + "." + name);
		builder.id(new ResourceLocation(ThermalGolems.MODID, name), ++entityCount);
		builder.tracker(48, 3, true);
		return builder.build();
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) {
		event.getRegistry().register(
				new BlockUtilityFixed(Material.GLASS, 0.5F, 2, Blocks.AIR.getDefaultState())
					.setRegistryName(ThermalGolems.MODID, "block_glow_fixed"));
	}
	
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
		event.getRegistry().registerAll(
			build(EntityAluminumGolem.class, ThermalGolemNames.ALUMINUM_GOLEM, TFBlocks.blockStorage),
			build(EntityBronzeGolem.class, ThermalGolemNames.BRONZE_GOLEM, TFBlocks.blockStorageAlloy),
			build(EntityCoalCokeGolem.class, ThermalGolemNames.COALCOKE_GOLEM, TFBlocks.blockStorageResource),
			build(EntityConstantanGolem.class, ThermalGolemNames.CONSTANTAN_GOLEM),
			build(EntityCopperGolem.class, ThermalGolemNames.COPPER_GOLEM),
			build(EntityElectrumGolem.class, ThermalGolemNames.ELECTRUM_GOLEM),
			build(EntityEnderiumGolem.class, ThermalGolemNames.ENDERIUM_GOLEM),
			build(EntityHardGlassGolem.class, ThermalGolemNames.HARDGLASS_GOLEM),
			build(EntityInvarGolem.class, ThermalGolemNames.INVAR_GOLEM),
			build(EntityIridiumGolem.class, ThermalGolemNames.IRIDIUM_GOLEM),
			build(EntityLeadGolem.class, ThermalGolemNames.LEAD_GOLEM),
			build(EntityLumiumGolem.class, ThermalGolemNames.LUMIUM_GOLEM),
			build(EntityManaInfusedGolem.class, ThermalGolemNames.MANAINFUSED_GOLEM),
			build(EntityNickelGolem.class, ThermalGolemNames.NICKEL_GOLEM),
			build(EntityPlatinumGolem.class, ThermalGolemNames.PLATINUM_GOLEM),
			build(EntityRockwoolGolem.class, ThermalGolemNames.ROCKWOOL_GOLEM, TFBlocks.blockRockwool),
			build(EntitySignalumGolem.class, ThermalGolemNames.SIGNALUM_GOLEM),
			build(EntitySilverGolem.class, ThermalGolemNames.SILVER_GOLEM),
			build(EntitySteelGolem.class, ThermalGolemNames.STEEL_GOLEM),
			build(EntityTinGolem.class, ThermalGolemNames.TIN_GOLEM)	
		);
	}

	public static void registerLootTables() {
		// basic loot tables
		for(final String s : ThermalGolemNames.SINGLE_LOOT_TABLES) {
			registerLootTable(s);
		}
		// multi-texture loot tables
		registerLootTables(ThermalGolemNames.ROCKWOOL_GOLEM, EntityRockwoolGolem.COLOR_ARRAY.length);
	}
	
	protected static void registerLootTable(final String name) {
		LootTableList.register(new ResourceLocation(ThermalGolems.MODID, "entities/" + name));
	}
	
	/**
	 * Registers multiple loot tables for each of the textures specified. They are registered under
	 * the subfile [name] and individually named according to each element in [textures]
	 */
	protected static void registerLootTables(final String name, final String[] textures) {
		for(String s : textures) {
			LootTableList.register(new ResourceLocation(ThermalGolems.MODID, "entities/" + name + "/" + s));
		}
	}
	
	/**
	 * Registers loot tables for GolemColorizedMultiTextured, with loot tables 
	 * registered under the subfile [name] and individually named '0' through '[max-1]'
	 */
	protected static void registerLootTables(final String name, final int max) {
		String[] array = new String[max];
		for (int i = 0; i < max; i++) {
			array[i] = Integer.toString(i);
		}
		registerLootTables(name, array);
	}
}
