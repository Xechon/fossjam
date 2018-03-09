package trigstar.usefulentities.btree.leaf;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import trigstar.usefulentities.btree.*;

public class FollowTarget extends Node {

    @Override
    public Result update() {
        Entity target = blackboard.targetEntity;
        EntityLiving entity = blackboard.entity;
        entity.getLookHelper().setLookPositionWithEntity(target, (float)(entity.getHorizontalFaceSpeed() + 20), (float)entity.getVerticalFaceSpeed());

        if (entity.getDistanceSq(target) < 6.25D)
        {
            entity.getNavigator().clearPath();
        }
        else
        {
            entity.getNavigator().tryMoveToEntityLiving(target, 1);
        }
        return Result.SUCCESS;
    }
}
