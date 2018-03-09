package trigstar.usefulentities.btree.leaf;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class PickupFromInventory extends Node {
    public ItemStack stack;

    public PickupFromInventory(ItemStack stack){
        this.stack = stack;
    }

    @Override
    public Result update() {
        //find block with inventory
        World world = blackboard.entity.world;
        TileEntity te = world.getTileEntity(blackboard.targetBlock);
        if(te != null && te instanceof IInventory) {
            IInventory inventory = ((IInventory) world.getTileEntity(blackboard.targetBlock));
            for (int i = 0; i < inventory.getSizeInventory(); i++) {
                ItemStack slotStack = inventory.getStackInSlot(i);
                if (slotStack.getItem() == stack.getItem() && slotStack.getItemDamage() == stack.getItemDamage()
                        && slotStack.getCount() >= stack.getCount()) {
                    inventory.decrStackSize(i, stack.getCount());
                    blackboard.inventory.addItem(stack);
                    return Result.SUCCESS;
                }
            }
        }
        return Result.FAILURE;
    }
}
