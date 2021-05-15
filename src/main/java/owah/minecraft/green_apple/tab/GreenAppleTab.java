package owah.minecraft.green_apple.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import owah.minecraft.green_apple.init.ItemInit;

public class GreenAppleTab extends CreativeTabs {
    public GreenAppleTab() {
        super("green_apple_tab");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemInit.CHEAT_GREEN_APPLE);
    }
}
