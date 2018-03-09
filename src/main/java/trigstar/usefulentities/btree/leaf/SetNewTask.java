package trigstar.usefulentities.btree.leaf;

import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class SetNewTask extends Node {

    @Override
    public Result update() {
        blackboard.shouldSwap = true;
        return Result.SUCCESS;
    }
}
