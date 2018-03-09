package trigstar.usefulentities.btree.leaf;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class PlaceBlock extends Node {
    Block block;

    public PlaceBlock(Block block) {
        this.block = block;
    }

    @Override
    public Result update() {
        return blackboard.entity.world.setBlockState(blackboard.targetBlock, block.getDefaultState()) ? Result.SUCCESS : Result.FAILURE;
    }
}