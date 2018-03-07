package trigstar.usefulentities.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.passive.EntityVillager;

import java.io.IOException;

public class VillagerJobsScreen extends GuiScreen{

    private EntityVillager villager;

    public VillagerJobsScreen(EntityVillager villager) {
        this.villager = villager;
    }

    @Override
    public void initGui()
    {
        GuiButton testButton1 = new GuiButton(0, 50, 50, 70, 20, "t1");
        GuiButton testButton2 = new GuiButton(0, 150, 50, 70, 20, "t2");
        GuiButton testButton3 = new GuiButton(0, 250, 50, 70, 20, "t3");

        addButton(testButton1);
        addButton(testButton2);
        addButton(testButton3);
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        if(villager != null) {
            switch (button.displayString) {
                case "t1":
                    System.out.println("t1 was pressed");
                    break;
                case "t2":
                    System.out.println("t2 was pressed");
                    break;
                case "t3":
                    System.out.println("t3 was pressed");
                    break;
            }
        }
    }
}
