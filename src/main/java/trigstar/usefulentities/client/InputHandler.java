package trigstar.usefulentities.client;

import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import trigstar.usefulentities.client.gui.VillagerJobsScreen;

public class InputHandler {

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeyBindings.testGUIKey.isPressed()) {
            //System.out.println("G was pressed");

            //FMLClientHandler.instance().showGuiScreen(new VillagerJobsScreen(null));
        }
    }
}