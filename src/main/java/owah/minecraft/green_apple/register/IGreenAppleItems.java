package owah.minecraft.green_apple.register;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;

public interface IGreenAppleItems {
    void registerItem(RegistryEvent.Register<Item> event);

    void registerModel(ModelRegistryEvent event);
}
