package seven.dupetrigger;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import seven.dupetrigger.network.DupeTriggerPacket;

public class KeybindEventHandler {

    private final SimpleNetworkWrapper networkWrapper;

    public KeybindEventHandler(SimpleNetworkWrapper networkWrapper) {
        this.networkWrapper = networkWrapper;
    }

    @SubscribeEvent
    public void onKeyInput(InputEvent.KeyInputEvent event) {
        if (KeybindHandler.dupeTriggerKey.isPressed()) {
            EntityPlayer player = Minecraft.getMinecraft().thePlayer;

            if (player != null && player.getHeldItem() != null) {
                ItemStack heldItem = player.getHeldItem();
                heldItem.stackSize *= 2;

                // Send packet to server
                networkWrapper.sendToServer(new DupeTriggerPacket());
            }
        }
    }
}
