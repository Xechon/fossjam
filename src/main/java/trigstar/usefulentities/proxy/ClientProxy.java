package trigstar.usefulentities.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import trigstar.usefulentities.client.InputHandler;
import trigstar.usefulentities.client.KeyBindings;
import trigstar.usefulentities.entity.ModEntities;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final String proxyPath = "trigstar.usefulentities.proxy.ClientProxy";

    @Override
    public void preInit() {
        super.preInit();
        ModEntities.initModels();


    }

    @Override
    public void init() {
        super.init();

        MinecraftForge.EVENT_BUS.register(new InputHandler());
        KeyBindings.init();
    }
}
