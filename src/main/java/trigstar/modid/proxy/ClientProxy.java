package trigstar.modid.proxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import trigstar.modid.entity.ModEntities;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final String proxyPath = "trigstar.modid.proxy.ClientProxy";

    @Override
    public void preInit() {
        super.preInit();
        ModEntities.initModels();
    }

    @Override
    public void init() {
        super.init();
        //ModEntities.initModels();
    }
}
