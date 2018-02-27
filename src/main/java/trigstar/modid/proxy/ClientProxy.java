package trigstar.modid.proxy;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.registries.IForgeRegistry;
import trigstar.modid.ExampleMod;
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
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
        EntityEntryBuilder<EntitySmartGolem> builder = EntityEntryBuilder.create();
        builder.entity(EntitySmartGolem.class).name("smart_golem").egg(0x000000, 0x000000)
                .id(new ResourceLocation(ExampleMod.MODID, "smart_golem"), 1)
                .factory(EntitySmartGolem::new).tracker(16, 3, true);
        //registry.register(new EntityEntry(EntitySmartGolem.class, "smart_golem"));
        registry.register(builder.build());
    }
}
