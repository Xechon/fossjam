package trigstar.usefulentities.btree;

public abstract class Node<T extends Blackboard> implements INode<T> {
    public T blackboard;
    public Node(T blackboard){
        this.blackboard = blackboard;
    }
}
