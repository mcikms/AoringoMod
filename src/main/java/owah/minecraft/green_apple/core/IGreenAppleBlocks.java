package owah.minecraft.green_apple.core;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;

public interface IGreenAppleBlocks extends IGreenAppleObject{
    void registerBlock(RegistryEvent.Register<Block> event);
}
