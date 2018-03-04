package trigstar.usefulentities.btree.select;

import net.minecraft.entity.Entity;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.ITargetAction;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class SelectorNearestPlayer extends Node<Blackboard> {
    public ITargetAction node;
    public double searchDistance;

    public SelectorNearestPlayer(Blackboard blackboard, ITargetAction action, double searchDistance) {
        super(blackboard);
        this.node = action;
        this.searchDistance = searchDistance;
    }

    @Override
    public Result update() {
        Entity target = blackboard.entity.world.getClosestPlayerToEntity(blackboard.entity, searchDistance);
        if(target != null) {
            node.setTarget(target);
            return node.update();
        }
        return Result.FAILURE;
    }
}
