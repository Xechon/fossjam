package trigstar.usefulentities.btree.deco;

import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;

public abstract class DecoratorNode extends Node{
    INode node;

    public DecoratorNode(Blackboard blackboard, INode node) {
        super(blackboard);
        this.node = node;
    }
}
