package trigstar.usefulentities.btree.leaf;

import net.minecraft.util.math.BlockPos;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class BlockOffset extends Node {
    int x,y,z;

    public BlockOffset(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Result update() {
        blackboard.targetBlock = blackboard.targetBlock.add(x,y,z);
        return Result.SUCCESS;
    }
}
