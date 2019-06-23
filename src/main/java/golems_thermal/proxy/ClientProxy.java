package golems_thermal.proxy;

import golems_thermal.entity.thermal_foundation.EntityCopperGolem;
import golems_thermal.main.ThermalGolems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = ThermalGolems.MODID)
public class ClientProxy extends CommonProxy {
	
	@SubscribeEvent
	public static void registerModels(final ModelRegistryEvent event) {
		com.golems.proxies.ClientProxy.registerEntityRender(EntityCopperGolem.class);
	}
}
