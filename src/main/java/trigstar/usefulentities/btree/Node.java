package trigstar.usefulentities.btree;

public abstract class Node<T extends Blackboard> implements INode<T> {
    public T blackboard;

    @Override
    public T getBlackboard() {
        return blackboard;
    }

    @Override
    public void setBlackboard(T blackboard) {
       this.blackboard = blackboard;
    }
}
