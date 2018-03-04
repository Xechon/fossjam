package trigstar.usefulentities.btree.leaf;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import trigstar.usefulentities.btree.*;

public class FollowTarget extends Node implements ITargetAction {
    private Entity target;

    public FollowTarget(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public void setTarget(Entity entity) {
        target = entity;
    }

    @Override
    public Result update() {
        EntityLiving entity = blackboard.entity;
        entity.getLookHelper().setLookPositionWithEntity(target, (float)(entity.getHorizontalFaceSpeed() + 20), (float)entity.getVerticalFaceSpeed());

        if (entity.getDistanceSq(this.target) < 6.25D)
        {
            entity.getNavigator().clearPath();
        }
        else
        {
            entity.getNavigator().tryMoveToEntityLiving(this.target, .5);
        }
        return Result.SUCCESS;
    }
}
