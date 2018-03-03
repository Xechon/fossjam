package trigstar.usefulentities.entity.event;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trigstar.usefulentities.entity.ai.EntityAIObserve;


@Mod.EventBusSubscriber
public class InjectAIHandler {
    @SubscribeEvent public static void onEntitySpawn(LivingSpawnEvent event) {
        if(event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) event.getEntity();
            villager.tasks.addTask(0, new EntityAIObserve(villager));
        }
    }

    @SubscribeEvent public static void onPlayerAttack(PlayerInteractEvent event) {

    }

    /*@SubscribeEvent public static void onPlayerInteract() {

    }*/
}
