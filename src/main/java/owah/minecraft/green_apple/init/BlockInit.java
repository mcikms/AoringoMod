package owah.minecraft.green_apple.init;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import owah.minecraft.green_apple.block.GreenAppleMachine;
import owah.minecraft.green_apple.core.IGreenAppleBlocks;

import java.util.ArrayList;
import java.util.List;

public class BlockInit {
    public static final List<IGreenAppleBlocks> BLOCKS = new ArrayList<IGreenAppleBlocks>();

    public static final Block GREEN_APPLE_MACHINE = new GreenAppleMachine();
}
