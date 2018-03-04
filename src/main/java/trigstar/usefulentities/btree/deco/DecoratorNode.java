package trigstar.usefulentities.btree.deco;

import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;

public abstract class DecoratorNode extends Node{
    Node node;

    public DecoratorNode(Blackboard blackboard, Node node) {
        super(blackboard);
        this.node = node;
    }
}
