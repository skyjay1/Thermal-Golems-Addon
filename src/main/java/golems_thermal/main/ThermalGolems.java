package golems_thermal.main;


import golems_thermal.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
@Mod(modid = ThermalGolems.MODID, name = ThermalGolems.NAME, version = ThermalGolems.VERSION)
public class ThermalGolems {
	
	public static final String MODID = "golems_thermal";
	public static final String NAME = "Thermal Golems Addon";
	public static final String VERSION = "7.1.5-0";
	
	@GameRegistry.ObjectHolder("block_glow_fixed")
	public static Block blockGlowFixed;
	
	@SidedProxy(clientSide = MODID + ".proxy.ClientProxy", serverSide = MODID + ".proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@Mod.Instance(ThermalGolems.MODID)
	public static ThermalGolems instance;

	@EventHandler
	public void preInit(final FMLPreInitializationEvent event) {
		ThermalGolemConfig.initGolemConfigSets(new Configuration(event.getSuggestedConfigurationFile()));
	}

	@EventHandler
	public void init(final FMLInitializationEvent event) {
		
	}
}
