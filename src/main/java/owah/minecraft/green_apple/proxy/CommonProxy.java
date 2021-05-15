package owah.minecraft.green_apple.proxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import owah.minecraft.green_apple.GreenApple;
import owah.minecraft.green_apple.core.GuiHandler;
import owah.minecraft.green_apple.init.BlockInit;
import owah.minecraft.green_apple.init.ItemInit;
import owah.minecraft.green_apple.tile.TileEntityMachine;

@Mod.EventBusSubscriber(modid = GreenApple.MODID)
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        GameRegistry.registerTileEntity(TileEntityMachine.class, "green_apple:green_apple_machine_tile_entity");
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }
    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        ItemInit.ITEMS.forEach(f -> f.registerItem(event));
    }
    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event) { // 追記
        BlockInit.BLOCKS.forEach(f -> f.registerBlock(event));
    }
}
