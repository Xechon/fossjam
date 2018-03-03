package trigstar.usefulentities.btree.select;

import trigstar.usefulentities.btree.BranchNode;
import trigstar.modid.btree.Node;

public class SelectorAll extends BranchNode {

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
