package trigstar.usefulentities.btree.leaf;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class MoveTo extends Node {

    @Override
    public Result update() {
        BlockPos blockPos = blackboard.targetBlock;
        boolean b = blackboard.entity.getNavigator().tryMoveToXYZ(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1d);
        return b ? Result.SUCCESS : Result.FAILURE;
    }
}
