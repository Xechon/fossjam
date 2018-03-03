package trigstar.usefulentities.entity.ai;

import com.google.common.collect.Sets;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;

public class EntityAIObserve extends EntityAIBase {
    private final EntityVillager villager;
    private EntityPlayer player;

    public EntityAIObserve(EntityVillager villager) {
        this.villager = villager;
    }

    @Override
    public boolean shouldExecute() {
        //noinspection ConstantConditions
        return villager.isTrading() && villager.getCustomer().getHeldItemMainhand().getItem() == Items.GOLD_INGOT;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return villager.canEntityBeSeen(player) && player.getHeldItemMainhand().getItem() == Items.GOLD_INGOT;
    }

    @Override
    public void startExecuting() {
        player = villager.getCustomer();
        //time & pos
    }

    @Override
    public void updateTask() {
        super.updateTask();
        new EntityAITempt(villager, 1d, false, Sets.newHashSet(Items.GOLD_INGOT));
        //record blocks & items interacted with and hit
        //events?
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }
}
