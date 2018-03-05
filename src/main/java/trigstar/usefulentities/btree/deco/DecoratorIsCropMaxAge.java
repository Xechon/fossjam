package trigstar.usefulentities.btree.deco;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.IBlockPosAction;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Result;

public class DecoratorIsCropMaxAge extends DecoratorNode implements IBlockPosAction {
    BlockPos blockPos;

    public DecoratorIsCropMaxAge(Blackboard blackboard, INode node) {
        super(blackboard, node);
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    @Override
    public Result update() {
        IBlockState blockState = blackboard.entity.world.getBlockState(blockPos);
        if(blockState.getBlock() instanceof BlockCrops) {
            if (((BlockCrops) blockState.getBlock()).isMaxAge(blockState)) {
                ((IBlockPosAction) node).setBlockPos(blockPos);
                return node.update();
            }
        }
        return Result.FAILURE;
    }
}
