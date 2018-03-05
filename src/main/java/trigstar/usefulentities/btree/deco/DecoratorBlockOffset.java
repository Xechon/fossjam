package trigstar.usefulentities.btree.deco;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.IBlockPosAction;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorBlockOffset extends DecoratorNode implements IBlockPosAction {
    int x,y,z;
    BlockPos blockPos;

    public DecoratorBlockOffset(Blackboard blackboard, int x, int y, int z, IBlockPosAction node) {
        super(blackboard, node);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void setBlockPos(BlockPos blockPos) {
        this.blockPos = blockPos;
    }

    @Override
    public Result update() {
        ((IBlockPosAction) node).setBlockPos(blockPos.add(x,y,z));
        return node.update();
    }
}
