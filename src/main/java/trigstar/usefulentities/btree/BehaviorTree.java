package trigstar.usefulentities.btree;

import net.minecraft.entity.ai.EntityAIBase;

public class BehaviorTree<T extends Blackboard> extends EntityAIBase {
    private Node trunk;
    public T blackboard;

    public BehaviorTree(T blackboard, Node trunk) {
        this.blackboard = blackboard;
        this.trunk = trunk;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return true; // false if?
    }

    @Override
    public void startExecuting() {
        trunk.update();
    }

    @Override
    public void resetTask() {

    }

    @Override
    public void updateTask() {
        trunk.update();
    }
}
