package trigstar.usefulentities.entity.event;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.deco.DecoratorDebug;
import trigstar.usefulentities.btree.leaf.FollowTarget;
import trigstar.usefulentities.btree.select.SelectorNearestPlayer;


@Mod.EventBusSubscriber
public class InjectAIHandler {
    @SubscribeEvent public static void onEntitySpawn(LivingSpawnEvent event) {
        if(event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) event.getEntity();
            Blackboard blackboard = new Blackboard(villager);
            BehaviorTree tree =  new BehaviorTree<>(new Blackboard(villager),
                    new DecoratorDebug(blackboard,
                    new SelectorNearestPlayer(blackboard,
                    new FollowTarget(blackboard), 32d)));
            villager.tasks.addTask(4, tree);
        }
    }

    @SubscribeEvent public static void onPlayerAttack(PlayerInteractEvent event) {

    }

    /*@SubscribeEvent public static void onPlayerInteract() {

    }*/
}
