package trigstar.usefulentities.btree.leaf;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class PickupItemEntity extends Node {
    @Override
    public Result update() {
        World world = blackboard.entity.world;
        if (!world.isRemote && !blackboard.entity.isDead && world.getGameRules().getBoolean("mobGriefing"))
        {
            for (EntityItem entityitem : world.getEntitiesWithinAABB(EntityItem.class, blackboard.entity.getEntityBoundingBox().grow(1.0D, 0.0D, 1.0D)))
            {
                if (!entityitem.isDead && !entityitem.getItem().isEmpty() && !entityitem.cannotPickup())
                {
                    blackboard.inventory.addItem(entityitem.getItem());
                    return Result.SUCCESS;
                }
            }
        }
        return Result.FAILURE;
    }
}
