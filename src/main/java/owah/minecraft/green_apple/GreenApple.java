package owah.minecraft.green_apple;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import owah.minecraft.green_apple.proxy.CommonProxy;

@Mod(modid = GreenApple.MODID, name = GreenApple.NAME, version = GreenApple.VERSION)
public class GreenApple {
    public static final String MODID = "green_apple"; //ModのID
    public static final String NAME = "Green Apple"; //Modの表示名
    public static final String VERSION = "1.0"; //Modのバージョン

    public static Logger logger; //Modのロガー

    public static final String CLIENT_PROXY = "owah.minecraft." + MODID + ".proxy.ClientProxy"; // 追記
    public static final String SERVER_PROXY = "owah.minecraft." + MODID + ".proxy.ServerProxy"; // 追記

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = SERVER_PROXY) // 追記
    public static CommonProxy proxy; // 追記

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(proxy); // 追記
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event); // 追記
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("The init begins");
        proxy.init(event); // 追記
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        logger.info("The postInit begins");
        proxy.postInit(event); // 追記
    }
}
