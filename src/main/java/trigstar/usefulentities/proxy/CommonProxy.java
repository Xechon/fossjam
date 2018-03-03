package trigstar.usefulentities.proxy;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static final String proxyPath = "trigstar.usefulentities.proxy.CommonProxy";

    public void preInit(){}

    public void init(){
        //ModEntities.init();
    }

    public void postInit(){}


}
