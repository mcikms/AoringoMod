package owah.minecraft.green_apple.Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.core.IGreenAppleItems;
import owah.minecraft.green_apple.init.ItemInit;

public class SpeedUpgrade extends Item implements IItemUpgrade, IGreenAppleItems {
    public static final String DEFAULT_NAME = "speed_upgrade";
    public SpeedUpgrade(){
        this.setUnlocalizedName(DEFAULT_NAME);
        this.setRegistryName(GreenApple.MODID, DEFAULT_NAME);
        this.setCreativeTab(GreenApple.creativeTabs);

        ItemInit.ITEMS.add(this);
    }
    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(new ResourceLocation(GreenApple.MODID, DEFAULT_NAME), "inventory"));
    }
}
