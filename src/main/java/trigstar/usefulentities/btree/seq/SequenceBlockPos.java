package trigstar.usefulentities.btree.seq;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.*;

public class SequenceBlockPos extends BranchNode implements IBlockPosAction{
    BlockPos blockPos;
    IBlockPosAction[] nodes;

    public SequenceBlockPos(Blackboard blackboard, IBlockPosAction... nodes) {
        super(blackboard);
        this.nodes = nodes;
    }

    @Override
    public Result update() {
        for (IBlockPosAction a : nodes) {
            a.setBlockPos(blockPos);
            if(a.update() == Result.FAILURE) {
                return Result.FAILURE;
            }
        }
        return Result.SUCCESS;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }
}
