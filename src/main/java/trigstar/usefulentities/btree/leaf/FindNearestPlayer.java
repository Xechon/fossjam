package trigstar.usefulentities.btree.leaf;

import net.minecraft.entity.Entity;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class FindNearestPlayer extends Node {
    int searchDistance;

    public FindNearestPlayer(int searchDistance) {
        this.searchDistance = searchDistance;
    }

    @Override
    public Result update() {
        Entity target = blackboard.entity.world.getClosestPlayerToEntity(blackboard.entity, searchDistance);
        if(target != null) {
            blackboard.targetEntity = target;
            return Result.SUCCESS;
        }
        return Result.FAILURE;
    }
}
