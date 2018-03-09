package trigstar.usefulentities.btree.deco;

import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;

public abstract class DecoratorNode<T extends Blackboard> extends Node<T>{
    Node node;

    public DecoratorNode(Node node){
        this.node = node;
        this.node.setBlackboard(blackboard);
    }

    @Override
    public void setBlackboard(T blackboard) {
        super.setBlackboard(blackboard);
        node.setBlackboard(blackboard);
    }
}
