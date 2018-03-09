package trigstar.usefulentities.btree.deco;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorIsCropMaxAge extends DecoratorNode {
    BlockPos blockPos;

    public DecoratorIsCropMaxAge(Node node) {
        super(node);
    }

    @Override
    public Result update() {
        IBlockState blockState = blackboard.entity.world.getBlockState(blockPos);
        if(blockState.getBlock() instanceof BlockCrops) {
            if (((BlockCrops) blockState.getBlock()).isMaxAge(blockState)) {
                return Result.SUCCESS;
            }
        }
        return Result.FAILURE;
    }
}
