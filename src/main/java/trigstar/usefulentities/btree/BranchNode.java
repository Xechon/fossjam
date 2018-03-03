package trigstar.usefulentities.btree;

public class BranchNode extends Node {
    protected Node[] nodes;

    public BranchNode(BehaviorTree tree) {
        super(tree);
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }
}
