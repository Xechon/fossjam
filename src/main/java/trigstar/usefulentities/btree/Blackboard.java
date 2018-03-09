package trigstar.usefulentities.btree;


import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.util.math.BlockPos;

public class Blackboard {
    public EntityLiving entity;
    public BlockPos targetBlock = BlockPos.ORIGIN;
    public Entity targetEntity = null;
    public InventoryBasic inventory;
    public Node tempRoot;
    public String phase = "Default";
    public boolean shouldSwap = false;

    public Blackboard(EntityLiving entity, InventoryBasic inventory) {
        this.entity = entity;
        this.inventory = inventory;
    }
}
