package trigstar.usefulentities.btree.leaf;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class IsCropMaxAge extends Node {
    @Override
    public Result update() {
        IBlockState state = blackboard.entity.world.getBlockState(blackboard.targetBlock);
        if(state.getBlock() instanceof BlockCrops && ((((BlockCrops) state.getBlock()).isMaxAge(state)))) {
            return Result.SUCCESS;
        }
        return Result.FAILURE;
    }
}
