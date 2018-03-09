package trigstar.usefulentities.btree.deco;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorTimer extends DecoratorNode {
    long time;
    long lastTime;

    public DecoratorTimer(long ticks, Node node) {
        super(node);
        this.time = ticks;
    }

    @Override
    public void setBlackboard(Blackboard blackboard) {
        super.setBlackboard(blackboard);
        lastTime = blackboard.entity.world.getTotalWorldTime();
    }

    @Override
    public Result update() {
        World world = blackboard.entity.world;
        if(world.getTotalWorldTime() - lastTime >= time){
            lastTime = world.getTotalWorldTime();
            return node.update();
        }
        return Result.FAILURE;
    }
}
