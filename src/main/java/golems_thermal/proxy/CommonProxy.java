package golems_thermal.proxy;

import com.golems.entity.GolemBase;
import com.golems.util.GolemLookup;

import cofh.thermalfoundation.init.TFBlocks;
import golems_thermal.entity.ThermalGolemNames;
import golems_thermal.entity.thermal_foundation.EntityCopperGolem;
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
			build(EntityCopperGolem.class, ThermalGolemNames.COPPER_GOLEM, TFBlocks.blockStorage)
		);
	}

	
	protected static void registerLootTable(final String name) {
		LootTableList.register(new ResourceLocation(ThermalGolems.MODID, "entities/" + name));
	}
}
