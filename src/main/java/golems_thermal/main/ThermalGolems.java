package golems_thermal.main;


import org.apache.logging.log4j.Logger;

import golems_thermal.proxy.CommonProxy;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber
@Mod(modid = ThermalGolems.MODID, name = ThermalGolems.NAME, version = ThermalGolems.VERSION)
public class ThermalGolems {
	
	public static final String MODID = "golems_thermal";
	public static final String NAME = "Thermal Golems Addon";
	public static final String VERSION = "7.1.5-0";
	
	@SidedProxy(clientSide = MODID + ".proxy.ClientProxy", serverSide = MODID + ".proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance(ThermalGolems.MODID)
	public static ThermalGolems instance;

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public static void registerEntities(final RegistryEvent.Register<EntityEntry> event) {
		proxy.registerEntities(event);
	}
}
