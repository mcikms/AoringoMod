package owah.minecraft.green_apple.Item;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.register.IGreenAppleItems;
import owah.minecraft.green_apple.register.ItemInit;

public class CheatGreenApple extends ItemFood implements IGreenAppleItems {
    private final String DEFAULT_NAME = "cheat_green_apple";

    public CheatGreenApple() {
        super(100, false);
        this.setUnlocalizedName(this.DEFAULT_NAME);
        this.setRegistryName(GreenApple.MODID, this.DEFAULT_NAME);
        this.setCreativeTab(CreativeTabs.MISC);

        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(this);
    }

    @Override
    public void registerModel(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(new ResourceLocation(GreenApple.MODID, this.DEFAULT_NAME), "inventory"));
    }
}
