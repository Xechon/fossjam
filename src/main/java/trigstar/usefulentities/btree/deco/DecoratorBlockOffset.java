package trigstar.usefulentities.btree.deco;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorBlockOffset extends DecoratorNode {
    int x,y,z;
    BlockPos blockPos;

    public DecoratorBlockOffset(int x, int y, int z, Node node) {
        super(node);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Result update() {
        blackboard.targetBlock.add(x,y,z);
        return node.update();
    }
}
