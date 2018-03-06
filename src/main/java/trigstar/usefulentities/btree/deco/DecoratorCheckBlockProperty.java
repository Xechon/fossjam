package trigstar.usefulentities.btree.deco;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.IBlockPosAction;
import trigstar.usefulentities.btree.Result;

public class DecoratorCheckBlockProperty<T extends Comparable<T>> extends DecoratorNode implements IBlockPosAction {
    BlockPos blockPos;
    IProperty<T> property;
    T value;

    public DecoratorCheckBlockProperty(Blackboard blackboard, IProperty<T> property, T value, IBlockPosAction node) {
        super(blackboard, node);
        this.property = property;
        this.value = value;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    @Override
    public Result update() {
        IBlockState blockState = blackboard.entity.world.getBlockState(blockPos);

        if(blockState.getValue(property) == value){
            ((IBlockPosAction)node).setBlockPos(blockPos);
            return node.update();
        }
        return Result.FAILURE;
    }
}
