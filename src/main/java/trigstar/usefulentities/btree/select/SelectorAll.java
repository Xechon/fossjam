package trigstar.usefulentities.btree.select;

import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.BranchNode;
import trigstar.usefulentities.btree.Node;

public class SelectorAll extends BranchNode {

    public SelectorAll(BehaviorTree tree) {
        super(tree);
    }

    @Override
    public void startExecuting() {
        for (Node n : nodes) {
            n.startExecuting();
        }
    }

    @Override
    public void updateTask() {
        for (Node n : nodes) {
            n.updateTask();
        }
    }

    @Override
    public boolean shouldContinueExecuting() {
        return true;
    }

    @Override
    public void resetTask() {
        for(Node n : nodes) {
            n.resetTask();
        }
    }
}
