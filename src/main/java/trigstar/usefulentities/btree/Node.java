package trigstar.usefulentities.btree;

import net.minecraft.entity.ai.EntityAIBase;

public abstract class Node<T> extends EntityAIBase {
    protected BehaviorTree<T> root;

    public Node(BehaviorTree<T> tree) {
        root = tree;
    }

    @Override
    public boolean shouldExecute() {
        return true;
    }
}
