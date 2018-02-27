package trigstar.modid.proxy;

import net.minecraftforge.fml.common.Mod;
import trigstar.modid.entity.ModEntities;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static final String proxyPath = "trigstar.modid.proxy.CommonProxy";

    public void preInit(){}

    public void init(){
        //ModEntities.init();
    }


}
