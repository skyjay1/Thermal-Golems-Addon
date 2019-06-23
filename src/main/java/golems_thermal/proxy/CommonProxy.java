package golems_thermal.proxy;

import com.golems.entity.GolemBase;
import com.golems.util.GolemLookup;

import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.thermal_foundation.*;
import golems_thermal.main.ThermalGolems;
import net.minecraft.block.Block;
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

	
	protected static void registerLootTable(final String name) {
		LootTableList.register(new ResourceLocation(ThermalGolems.MODID, "entities/" + name));
	}
}
