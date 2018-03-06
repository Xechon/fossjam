package trigstar.usefulentities.client;


import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;


@SideOnly(Side.CLIENT)
public class KeyBindings {

    public static KeyBinding testGUIKey;

    public static void init() {
        testGUIKey = new KeyBinding("key.testGUI", Keyboard.KEY_G, "key.categories.usefulentities");
        ClientRegistry.registerKeyBinding(testGUIKey);
    }
}