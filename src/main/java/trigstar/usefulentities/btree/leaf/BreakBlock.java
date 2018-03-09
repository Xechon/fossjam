package trigstar.usefulentities.btree.leaf;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class BreakBlock extends Node {

    @Override
    public Result update() {
        return blackboard.entity.world.destroyBlock(blackboard.targetBlock, true) ? Result.SUCCESS : Result.FAILURE;
    }
}
