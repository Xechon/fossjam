package trigstar.modid.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import trigstar.modid.entity.ModEntities;

@Mod.EventBusSubscriber
public class CommonProxy {
    public static final String proxyPath = "trigstar.modid.proxy.CommonProxy";

    public void init(){
        ModEntities.init();
    }
}
