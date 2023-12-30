package seven.dupetrigger;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class KeybindHandler {

    public static KeyBinding dupeTriggerKey;

    public static void init() {
        dupeTriggerKey = new KeyBinding("Dupe Trigger Keybind", Keyboard.KEY_EQUALS, "key.categories.misc");
        ClientRegistry.registerKeyBinding(dupeTriggerKey);

    }
}
