package trigstar.usefulentities.btree.seq;

import trigstar.usefulentities.btree.BranchNode;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class SequenceUntilFail extends BranchNode {

    public SequenceUntilFail(Node... nodes){
        super(nodes);
    }

    @Override
    public Result update() {
        for (Node n : nodes) {
            if(n.update() == Result.FAILURE) {
                return Result.FAILURE;
            }
        }
        return Result.SUCCESS;
    }
}
