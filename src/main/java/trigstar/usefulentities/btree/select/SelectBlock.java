package trigstar.usefulentities.btree.select;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import trigstar.usefulentities.btree.*;

public class SelectBlock extends Node{
    Block block;
    TaskArea area;
    IBlockPosAction node;

    public SelectBlock(Blackboard blackboard, Block block, TaskArea area, IBlockPosAction node) {
        super(blackboard);
        this.block = block;
        this.area = area;
        this.node = node;
    }

    @Override
    public Result update() {
        BlockPos pos = findBlock(area);



        if(pos != null) {
            node.setBlockPos(pos);
            return node.update();
        }
        return Result.FAILURE;
    }

    public BlockPos findBlock(TaskArea area) {
        BlockPos blockPos = blackboard.entity.getPosition();
        int range = 32;

        for (int k = 0; k <= 1; k = k > 0 ? -k : 1 - k)
        {
            for (int l = 0; l < range; ++l)
            {
                for (int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1)
                {
                    for (int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1)
                    {
                        BlockPos blockpos1 = blockPos.add(i1, k - 1, j1);

                        if (this.shouldSelect(blackboard.entity.world, blockpos1))
                        {
                            return blockpos1;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean shouldSelect(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);
        if(state.getBlock() == block){
            return true;
        }
        return false;
    }
}
