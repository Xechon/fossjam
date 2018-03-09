package trigstar.usefulentities.btree.deco;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorCheckBlockProperty<T extends Comparable<T>> extends DecoratorNode {
    BlockPos blockPos;
    IProperty<T> property;
    T value;

    public DecoratorCheckBlockProperty(IProperty<T> property, T value, Node node) {
        super(node);
        this.property = property;
        this.value = value;
    }

    @Override
    public Result update() {
        IBlockState blockState = blackboard.entity.world.getBlockState(blockPos);

        if(blockState.getValue(property) == value){
            return Result.SUCCESS;
        }
        return Result.FAILURE;
    }
}
