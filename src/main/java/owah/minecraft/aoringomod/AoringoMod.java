package owah.minecraft.aoringomod;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = AoringoMod.MODID, name = AoringoMod.NAME, version = AoringoMod.VERSION)
public class AoringoMod {
    public static final String MODID = "aoringomod";
    public static final String NAME = "AoringoMod";
    public static final String VERSION = "1.0";

    public static Logger logger;

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("The preInit begins");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("The init begins");
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("The postInit begins");
    }
}
