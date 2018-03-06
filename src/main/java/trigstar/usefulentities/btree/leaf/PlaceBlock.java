package trigstar.usefulentities.btree.leaf;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.IBlockPosAction;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class PlaceBlock extends Node implements IBlockPosAction{
    BlockPos blockPos;
    Block block;

    public PlaceBlock(Blackboard blackboard, Block block) {
        super(blackboard);
        this.block = block;
    }

    @Override
    public Result update() {
        return blackboard.entity.world.setBlockState(blockPos, block.getDefaultState()) ? Result.SUCCESS : Result.FAILURE;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }
}