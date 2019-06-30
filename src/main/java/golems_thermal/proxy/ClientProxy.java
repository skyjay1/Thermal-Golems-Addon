package golems_thermal.proxy;

import golems_thermal.entity.thermal_foundation.*;
import golems_thermal.main.ThermalGolems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ThermalGolems.MODID)
public class ClientProxy extends CommonProxy {
	
	@SubscribeEvent
	public static void registerModels(final ModelRegistryEvent event) {
		// GOLEM MODELS AND RENDERS
		com.golems.proxies.ClientProxy.registerEntityRender(EntityAluminumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityBronzeGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityCoalCokeGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityConstantanGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityCopperGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityElectrumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityEnderiumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityHardGlassGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityInvarGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityIridiumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityLeadGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityLumiumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityManaInfusedGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityNickelGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityPlatinumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityRockwoolGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntitySignalumGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntitySilverGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntitySteelGolem.class);
		com.golems.proxies.ClientProxy.registerEntityRender(EntityTinGolem.class);
		
		// BLOCK MODELS AND RENDERS
	}
}
