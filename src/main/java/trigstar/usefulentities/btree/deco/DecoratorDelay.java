package trigstar.usefulentities.btree.deco;

import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorDelay extends DecoratorNode{
    int delay, countdown;

    public DecoratorDelay(int delay, Node node) {
        super(node);
        this.delay = delay;
        this.countdown = 0;
    }

    @Override
    public Result update() {
        if(countdown <= 0){
            countdown = delay;
            return node.update();
        } else {
            countdown--;
            return Result.FAILURE;
        }
    }
}
