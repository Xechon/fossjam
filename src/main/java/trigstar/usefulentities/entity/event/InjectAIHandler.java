package trigstar.usefulentities.entity.event;

import net.minecraft.block.BlockCrops;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.TaskArea;
import trigstar.usefulentities.btree.deco.*;
import trigstar.usefulentities.btree.leaf.BreakBlock;
import trigstar.usefulentities.btree.leaf.FollowTarget;
import trigstar.usefulentities.btree.leaf.MoveTo;
import trigstar.usefulentities.btree.leaf.PlaceBlock;
import trigstar.usefulentities.btree.select.SelectBlock;
import trigstar.usefulentities.btree.select.SelectorNearestPlayer;
import trigstar.usefulentities.btree.seq.SequenceBlockPos;
import trigstar.usefulentities.client.gui.VillagerJobsScreen;


@Mod.EventBusSubscriber
public class InjectAIHandler {
    @SubscribeEvent public static void onEntitySpawn(LivingSpawnEvent event) {
        if(event.getEntity() instanceof EntityVillager) {
            EntityVillager villager = (EntityVillager) event.getEntity();
            Blackboard blackboard = new Blackboard(villager);
            //select farmland, move to farmland, break crops, place seeds, till dirt
            BehaviorTree<Blackboard> farmer = new BehaviorTree<>(blackboard,
                    new SelectBlock(blackboard, Blocks.FARMLAND, new TaskArea(BlockPos.ORIGIN, 32),
                        new DecoratorBlockOffset(blackboard, 0, 1, 0,
                        new DecoratorIsCropMaxAge(blackboard,
                        new SequenceBlockPos(blackboard,
                            new MoveTo(blackboard),
                            new BreakBlock(blackboard),
                            new PlaceBlock(blackboard, Blocks.WHEAT))))));
            BehaviorTree<Blackboard> tree =  new BehaviorTree<>(blackboard,
                    new DecoratorDebug(blackboard,
                    new SelectorNearestPlayer(blackboard,
                            new DecoratorHasHeld(blackboard, Items.EMERALD,
                    new FollowTarget(blackboard)), 32d)));
            villager.tasks.addTask(4, farmer);
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
