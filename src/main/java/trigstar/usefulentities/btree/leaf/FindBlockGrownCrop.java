package trigstar.usefulentities.btree.leaf;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FindBlockGrownCrop extends FindBlock {
    @Override
    boolean shouldSelect(World world, BlockPos blockPos) {
        IBlockState blockState = world.getBlockState(blockPos);
        return (blockState.getBlock() instanceof BlockCrops && ((BlockCrops)blockState.getBlock()).isMaxAge(blockState));
    }
}
