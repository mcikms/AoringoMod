package owah.minecraft.green_apple.proxy;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import owah.minecraft.green_apple.register.ItemInit;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        ItemInit.ITEMS.forEach(f -> f.registerModel(event));
    }
}
