package trigstar.usefulentities;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import trigstar.usefulentities.proxy.ClientProxy;
import trigstar.usefulentities.proxy.CommonProxy;

@Mod(modid = UsefulEntities.MODID, name = UsefulEntities.NAME, version = UsefulEntities.VERSION)
public class UsefulEntities
{
    public static final String MODID = "usefulentities";
    public static final String NAME = "UsefulEntities";
    public static final String VERSION = "0.0.1";

    private static Logger logger;

    @SidedProxy(clientSide = ClientProxy.proxyPath, serverSide = CommonProxy.proxyPath) public static CommonProxy proxy;
    @Mod.Instance public static UsefulEntities instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }
}
