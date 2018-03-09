package trigstar.usefulentities.btree;

public interface INode<T extends Blackboard> {
    public Result update();
    public T getBlackboard();
    public void setBlackboard(T blackboard);
}