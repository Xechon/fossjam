package trigstar.usefulentities.btree;

import net.minecraft.entity.ai.EntityAIBase;

public class BehaviorTree<T> extends EntityAIBase {
    private Node root;
    public T blackboard;

    public BehaviorTree(T blackboard) {
        this.blackboard = blackboard;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }

    @Override
    public boolean shouldContinueExecuting() {
        return root.shouldContinueExecuting();
    }

    @Override
    public void startExecuting() {
        root.startExecuting();
    }

    @Override
    public void resetTask() {
        root.resetTask();
    }

    @Override
    public void updateTask() {
        root.updateTask();
    }
}
