package trigstar.usefulentities.btree.deco;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.ITargetAction;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorHasHeld extends DecoratorNode implements ITargetAction {
    Item heldItem;
    Entity target;

    public DecoratorHasHeld(Blackboard blackboard, Item heldItem, ITargetAction node) {
        super(blackboard, node);
        this.heldItem = heldItem;
    }

    @Override
    public void setTarget(Entity entity) {
        this.target = entity;
    }

    @Override
    public Result update() {
        if(target != null) {
            for (ItemStack itemStack : target.getHeldEquipment()) {
                if (itemStack.getItem() == heldItem) {
                    ((ITargetAction)node).setTarget(target);
                    return node.update();
                }
            }
        }
        return Result.FAILURE;
    }
}
