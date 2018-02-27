package trigstar.modid.proxy;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import trigstar.modid.entity.EntitySmartGolem;
import trigstar.modid.entity.ModEntities;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final String proxyPath = "trigstar.modid.proxy.ClientProxy";

    @Override
    public void init() {
        super.init();
        ModEntities.initModels();
    }

    @SubscribeEvent
    public void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();

        registry.register(new EntityEntry(EntitySmartGolem.class, "smart_golem"));
    }
}
