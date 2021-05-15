package owah.minecraft.green_apple.init;

import net.minecraft.item.Item;
import owah.minecraft.green_apple.Item.CheatGreenApple;
import owah.minecraft.green_apple.Item.SpeedUpgrade;
import owah.minecraft.green_apple.core.IGreenAppleItems;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<IGreenAppleItems> ITEMS = new ArrayList<IGreenAppleItems>();

    public static final Item CHEAT_GREEN_APPLE = new CheatGreenApple();
    public static final Item SPEED_UPGRADE = new SpeedUpgrade();
}
