package trigstar.usefulentities.btree.leaf;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.IBlockPosAction;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class BreakBlock extends Node implements IBlockPosAction {
    BlockPos blockPos;

    public BreakBlock(Blackboard blackboard) {
        super(blackboard);
    }

    @Override
    public Result update() {
        return blackboard.entity.world.setBlockToAir(blockPos) ? Result.SUCCESS : Result.FAILURE;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }
}
