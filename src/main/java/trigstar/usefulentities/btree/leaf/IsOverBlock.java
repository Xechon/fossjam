package trigstar.usefulentities.btree.leaf;

import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class IsOverBlock extends Node{

    @Override
    public Result update() {
        System.out.println(blackboard.entity.getPosition() + " : " + blackboard.targetBlock);
        return blackboard.entity.getDistanceSqToCenter(blackboard.targetBlock.up()) > 1.0D ? Result.SUCCESS : Result.FAILURE;
    }
}
