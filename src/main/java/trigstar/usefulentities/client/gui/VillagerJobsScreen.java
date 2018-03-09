package trigstar.usefulentities.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAITasks;
import net.minecraft.entity.passive.EntityVillager;
import trigstar.usefulentities.btree.BehaviorTree;
import trigstar.usefulentities.btree.Blackboard;
import trigstar.usefulentities.btree.Node;
import trigstar.usefulentities.btree.PrefabBehaviorTree;

import java.io.IOException;
import java.util.Iterator;

public class VillagerJobsScreen extends GuiScreen{

    private EntityVillager villager;

    public VillagerJobsScreen(EntityVillager villager) {
        this.villager = villager;
    }

    @Override
    public void initGui()
    {
        GuiButton testButton1 = new GuiButton(0, 50, 50, 70, 20, "Harvest");
        GuiButton testButton2 = new GuiButton(0, 150, 50, 70, 20, "Plow");
        GuiButton testButton3 = new GuiButton(0, 250, 50, 70, 20, "Sow");

        addButton(testButton1);
        addButton(testButton2);
        addButton(testButton3);
    }

    protected BehaviorTree findBehaviorTree(EntityVillager villager) {
        Iterator i = villager.tasks.taskEntries.iterator();
        while(i.hasNext()){
            Object entry = i.next();
            if(entry instanceof BehaviorTree) {
                return ((BehaviorTree)entry);
            }
        }
        return null;
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        if(villager != null) {
            //BehaviorTree tree = findBehaviorTree(villager);
            //if(tree != null) {
                switch (button.displayString) {
                    case "Harvest":
                        System.out.println("t1 was pressed");
                        break;
                    case "Plow":
                        System.out.println("t2 was pressed");
                        break;
                    case "Sow":
                        System.out.println("t3 was pressed");
                        break;
                }
                /*Node newBehavior = PrefabBehaviorTree.get(button.displayString, tree.blackboard);
                System.out.println("Switching Behavior to: " + button.displayString);
                if(newBehavior != null) {

                    tree.blackboard.tempRoot = newBehavior;
                }
            }*/
        }
    }
}
