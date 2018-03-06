package trigstar.usefulentities.btree;

import net.minecraft.util.math.BlockPos;

public interface IBlockPosAction extends INode {
    void setBlockPos(BlockPos blockPos);
}
