package trigstar.usefulentities.btree.seq;

import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.BranchNode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class SequenceAll extends BranchNode {

    public SequenceAll(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public Result update() {
        for (Node n : nodes) {
            n.update();
        }
        return Result.SUCCESS;
    }
}
