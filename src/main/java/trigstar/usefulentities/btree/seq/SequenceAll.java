package trigstar.usefulentities.btree.seq;

import trigstar.usefulentities.btree.*;

public class SequenceAll extends BranchNode {

    public SequenceAll(Node... nodes) {
        super(nodes);
    }

    @Override
    public Result update() {
        for (Node n : nodes) {
            n.update();
        }
        return Result.SUCCESS;
    }
}
