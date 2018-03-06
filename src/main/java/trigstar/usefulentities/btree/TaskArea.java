package trigstar.usefulentities.btree;

import net.minecraft.util.math.BlockPos;

public class TaskArea {
    public BlockPos origin;
    public int range;

    public TaskArea(BlockPos origin, int range) {
        this.origin = origin;
        this.range = range;
    }
}
