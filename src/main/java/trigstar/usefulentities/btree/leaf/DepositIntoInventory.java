package trigstar.usefulentities.btree.leaf;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.Result;

public class DepositIntoInventory extends Node {
    @Override
    public Result update() {
        //find block with inventory
        World world = blackboard.entity.world;
        TileEntity te = world.getTileEntity(blackboard.targetBlock);
        if(te != null && te instanceof IInventory) {
            IInventory inventory = ((IInventory) world.getTileEntity(blackboard.targetBlock));
            InventoryBasic entityInventory = blackboard.inventory;
            for (int i = 0; i < entityInventory.getSizeInventory(); i++) {
                for (int j = 0; j < inventory.getSizeInventory(); j++) {
                    if(inventory.isItemValidForSlot(j, entityInventory.getStackInSlot(i))){
                        inventory.setInventorySlotContents(j, inventory.getStackInSlot(i));
                        break;
                    }
                }
            }
        }
        return Result.SUCCESS;
    }
}
