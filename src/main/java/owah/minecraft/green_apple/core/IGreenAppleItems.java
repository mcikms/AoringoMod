package owah.minecraft.green_apple.core;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public interface IGreenAppleItems extends IGreenAppleObject{
    void registerItem(RegistryEvent.Register<Item> event);
}
