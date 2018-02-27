package trigstar.modid.btree;

import net.minecraft.entity.ai.EntityAIBase;

public class BehaviorTree extends EntityAIBase {
    public Node root;

    @Override
    public boolean shouldExecute() {
        return true;
    }
}
