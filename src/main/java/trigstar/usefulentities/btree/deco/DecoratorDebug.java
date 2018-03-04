package trigstar.usefulentities.btree.deco;

import trigstar.usefulentities.UsefulEntities;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorDebug extends DecoratorNode {

    public DecoratorDebug(Blackboard blackboard, Node node) {
        super(blackboard, node);
    }

    @Override
    public Result update() {
        Result r = node.update();
        UsefulEntities.logger.debug(node.getClass().getSimpleName() + " : " + r);
        System.out.println(node.getClass().getSimpleName() + " : " + r);
        return r;
    }
}
