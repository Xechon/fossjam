package trigstar.usefulentities.btree;

import java.util.ArrayList;

public abstract class BranchNode extends Node {
    protected ArrayList<Node> nodes;

    public BranchNode(Blackboard blackboard) {
        super(blackboard);
    }
}
