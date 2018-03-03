package trigstar.usefulentities.btree;

public class BranchNode extends Node {
    protected Node[] nodes;

    @Override
    public boolean shouldExecute() {
        return true;
    }
}
