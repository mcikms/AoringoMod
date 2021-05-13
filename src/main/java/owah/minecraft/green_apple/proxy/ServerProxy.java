package owah.minecraft.green_apple.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import owah.minecraft.green_apple.GreenApple;

public class ServerProxy extends CommonProxy{
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        GreenApple.logger.info("The preInit begins");
    }
    @Override
    public void init(FMLInitializationEvent event) {
        GreenApple.logger.info("The init begins");
    }
    @Override
    public void postInit(FMLPostInitializationEvent event) {
        GreenApple.logger.info("The postInit begins");
    }
}
