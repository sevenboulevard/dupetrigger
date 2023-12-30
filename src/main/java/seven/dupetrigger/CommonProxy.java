package seven.dupetrigger;

import cpw.mods.fml.relauncher.Side;
import seven.dupetrigger.network.DupeTriggerPacket;
import seven.dupetrigger.network.DupeTriggerPacketHandler;

public class CommonProxy {

    public void preInit() {
        // Register the packet and packet handler
        DupeTrigger.networkWrapper
            .registerMessage(DupeTriggerPacketHandler.class, DupeTriggerPacket.class, 0, Side.SERVER);

        // Initialize keybinds
        KeybindHandler.init();
    }
}
