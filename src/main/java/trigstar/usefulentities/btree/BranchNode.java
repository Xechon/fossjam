package trigstar.usefulentities.btree;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class BranchNode extends Node {
    protected ArrayList<Node> nodes = new ArrayList<>();

    public BranchNode(Node... nodes) {
        this.nodes.addAll(Arrays.asList(nodes));
    }

    @Override
    public void setBlackboard(Blackboard blackboard) {
        super.setBlackboard(blackboard);
        for (INode n : nodes) {
            n.setBlackboard(blackboard);
        }
    }
}
