package trigstar.usefulentities.btree.leaf;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

import java.util.ArrayList;
import java.util.Arrays;

public class FindBlock extends Node {
    ArrayList<Block> types = new ArrayList<>();

    public FindBlock(Block... types) {
        this.types.addAll(Arrays.asList(types));
    }

    @Override
    public Result update() {
        BlockPos blockPos;
        if(blackboard.jobInventory != null) {
            blockPos = blackboard.jobInventory;
        }else blockPos = blackboard.entity.getPosition();
        int range = 16;

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
                            blackboard.targetBlock = blockpos1;
                            return Result.SUCCESS;
                        }
                    }
                }
            }
        }
        return Result.FAILURE;
    }

    boolean shouldSelect(World world, BlockPos blockPos){
        IBlockState state = world.getBlockState(blockPos);
        return types.contains(state.getBlock());
    }
}
