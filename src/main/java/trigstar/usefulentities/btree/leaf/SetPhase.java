package trigstar.usefulentities.btree.leaf;

import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class SetPhase extends Node {
    String phase;

    public SetPhase(String phase){
        this.phase = phase;
    }

    @Override
    public Result update() {
        blackboard.phase = phase;
        return Result.SUCCESS;
    }
}
