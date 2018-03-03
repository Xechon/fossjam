package trigstar.usefulentities.proxy;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.SERVER)
public class ServerProxy extends CommonProxy{
    public static final String proxyPath = "trigstar.usefulentities.proxy.ServerProxy";



}
