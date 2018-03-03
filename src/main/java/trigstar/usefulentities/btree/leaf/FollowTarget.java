package trigstar.usefulentities.btree.leaf;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.ITargetAction;
import trigstar.usefulentities.btree.Node;

public class FollowTarget extends Node<EntityLiving> implements ITargetAction {
    private Entity target;

    public FollowTarget(BehaviorTree<EntityLiving> tree) {
        super(tree);
    }

    @Override
    public boolean shouldExecute() {
        return target != null;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return super.shouldContinueExecuting();
    }

    @Override
    public void startExecuting() {
        super.startExecuting();
    }

    @Override
    public void resetTask() {
        super.resetTask();
    }

    @Override
    public void updateTask() {
        EntityLiving entity = root.blackboard;
        entity.getLookHelper().setLookPositionWithEntity(target, (float)(entity.getHorizontalFaceSpeed() + 20), (float)entity.getVerticalFaceSpeed());

        if (entity.getDistanceSq(this.target) < 6.25D)
        {
            entity.getNavigator().clearPath();
        }
        else
        {
            entity.getNavigator().tryMoveToEntityLiving(this.target, 1);
        }
    }

    @Override
    public void setTarget(Entity entity) {
        target = entity;
    }
}
