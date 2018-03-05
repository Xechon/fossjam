package trigstar.usefulentities.btree.leaf;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.IBlockPosAction;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class MoveTo extends Node implements IBlockPosAction {
    BlockPos blockPos;

    public MoveTo(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public Result update() {
        boolean b = blackboard.entity.getNavigator().tryMoveToXYZ(blockPos.getX(), blockPos.getY(), blockPos.getZ(), 1d);
        return b ? Result.SUCCESS : Result.FAILURE;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }
}
