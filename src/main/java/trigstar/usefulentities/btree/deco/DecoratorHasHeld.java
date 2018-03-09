package trigstar.usefulentities.btree.deco;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.INode;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DecoratorHasHeld extends DecoratorNode {
    Item heldItem;

    public DecoratorHasHeld(Item heldItem, Node node) {
        super(node);
        this.heldItem = heldItem;
    }

    @Override
    public Result update() {
        Entity target = blackboard.targetEntity;
        if(target != null) {
            for (ItemStack itemStack : target.getHeldEquipment()) {
                if (itemStack.getItem() == heldItem) {
                    return node.update();
                }
            }
        }
        return Result.FAILURE;
    }
}
