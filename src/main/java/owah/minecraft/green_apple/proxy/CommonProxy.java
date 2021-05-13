package owah.minecraft.green_apple.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.register.ItemInit;

@Mod.EventBusSubscriber(modid = GreenApple.MODID)
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        ItemInit.ITEMS.forEach(f -> f.registerItem(event));
    }
}
