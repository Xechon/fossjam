package trigstar.usefulentities.btree;

import net.minecraft.entity.ai.EntityAIBase;

public class BehaviorTree<T extends Blackboard> extends EntityAIBase {
    private Node<T> trunk;
    public T blackboard;

    public BehaviorTree(T blackboard, Node<T> trunk) {
        this.blackboard = blackboard;
        this.trunk = trunk;
        trunk.setBlackboard(blackboard);
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
        if(blackboard.shouldSwap){
            if(blackboard.tempRoot != null) {
                swapTrunk();
                blackboard.shouldSwap = false;
            }
        }
        trunk.update();
    }

    public void swapTrunk(){
        Node temp = blackboard.tempRoot;
        blackboard.tempRoot = trunk;
        trunk = temp;

    }
}
