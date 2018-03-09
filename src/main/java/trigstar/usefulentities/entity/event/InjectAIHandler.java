package trigstar.usefulentities.entity.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHarvestFarmland;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Tuple;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.deco.*;
import trigstar.usefulentities.btree.leaf.*;
import trigstar.usefulentities.btree.select.SelectorPhase;
import trigstar.usefulentities.btree.seq.SequenceAll;
import trigstar.usefulentities.btree.seq.SequenceUntilFail;
import trigstar.usefulentities.client.gui.VillagerJobsScreen;

@Mod.EventBusSubscriber
public class InjectAIHandler {
    static EntityAIBase harvestAction;

    @SubscribeEvent public static void onEntitySpawn(LivingSpawnEvent event) {
        if(event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) event.getEntity();

            villager.tasks.taskEntries.forEach(e -> {
                if(e.action instanceof EntityAIHarvestFarmland){
                    harvestAction = e.action;
                }
            });
            villager.tasks.removeTask(harvestAction);
            Blackboard blackboard = new Blackboard(villager, new InventoryBasic("villager", true, 3));
            blackboard.phase = "FIND";

            BehaviorTree<Blackboard> acceptTask = new BehaviorTree<>(blackboard,
                    new SequenceAll(
                            new FindNearestPlayer(32),
                            new DecoratorHasHeld(Items.EMERALD,
                                    new FollowTarget()),
                            new SequenceUntilFail(
                                    new FindBlock(Blocks.CHEST),
                                    new PickupFromInventory(new ItemStack(Items.EMERALD,1)),
                                    new SetNewTask()
                            )
                    ));

            villager.tasks.addTask(4, acceptTask);
        }
    }

    /*@SubscribeEvent public static void onPlayerAttack(PlayerInteractEvent event) {

    }*/

    @SubscribeEvent
    public static void onPlayerInteract(PlayerInteractEvent.EntityInteract event) {
        EntityPlayer player = event.getEntityPlayer();
        Entity target = event.getTarget();
        System.out.println(player.getHeldEquipment());

        if(target instanceof EntityVillager) {
            for (ItemStack itemStack : player.getHeldEquipment()) {
                if (itemStack.getItem() == Items.EMERALD) {
                    //we've right clicked on a villager with an emerald in either our offhand or mainhand
                    //open jobs gui
                    FMLClientHandler.instance().showGuiScreen(new VillagerJobsScreen((EntityVillager) target));
                    if(event.isCancelable()) {
                        event.setCanceled(true);
                    }
                }
            }
        }
    }
}
