package owah.minecraft.green_apple.register;

import net.minecraft.item.Item;
import owah.minecraft.green_apple.Item.CheatGreenApple;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {
    public static final List<IGreenAppleItems> ITEMS = new ArrayList<IGreenAppleItems>();

    public static final Item CHEAT_GREEN_APPLE = new CheatGreenApple();
}
