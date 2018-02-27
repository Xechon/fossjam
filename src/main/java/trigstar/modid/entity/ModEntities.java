package trigstar.modid.entity;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import trigstar.modid.ExampleMod;
import trigstar.modid.entity.render.RenderSmartGolem;

public class ModEntities {

    public static void init(){
        //EntityRegistry.registerModEntity(registryname, entityClass, entityName, id, modObj, trackingRange, updateFrequency, sendsVelUpdates, eggPrime, eggSec);
        //(MRL, Class, String, int, Obj, int, int, bool, int, int)
        //EntityRegistry.registerModEntity(new ResourceLocation(ExampleMod.MODID, "smart_golem"), EntitySmartGolem.class, "SmartGolem", 1, ExampleMod.instance, 16, 3, true, 0x000000, 0x000000);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntitySmartGolem.class, RenderSmartGolem.FACTORY);
    }
}
