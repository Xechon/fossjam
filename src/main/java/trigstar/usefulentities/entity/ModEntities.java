package trigstar.usefulentities.entity;


import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.minecraftforge.registries.IForgeRegistry;
import trigstar.usefulentities.UsefulEntities;
import trigstar.usefulentities.entity.render.RenderSmartGolem;

@Mod.EventBusSubscriber
public class ModEntities {

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySmartGolem.class, RenderSmartGolem.FACTORY);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
        EntityEntryBuilder<EntitySmartGolem> builder = EntityEntryBuilder.create();
        builder.entity(EntitySmartGolem.class).name("smart_golem").egg(0x000000, 0x000000)
                .id(new ResourceLocation(UsefulEntities.MODID, "smart_golem"), 1)
                .factory(EntitySmartGolem::new).tracker(16, 3, true);
        registry.register(builder.build());
    }
}
