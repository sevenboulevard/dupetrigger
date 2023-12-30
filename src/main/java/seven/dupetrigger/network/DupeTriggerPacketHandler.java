package seven.dupetrigger.network;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import seven.dupetrigger.DupeTrigger;

public class DupeTriggerPacketHandler implements IMessageHandler<DupeTriggerPacket, IMessage> {

    @Override
    public IMessage onMessage(DupeTriggerPacket message, MessageContext ctx) {
        // Server-side handling
        EntityPlayerMP player = ctx.getServerHandler().playerEntity;

        if (player != null && player.getHeldItem() != null) {
            ItemStack heldItem = player.getHeldItem();
            heldItem.stackSize *= 2;

            // Send an update to the client to sync the changes
            DupeTrigger.networkWrapper.sendToAll(new DupeTriggerPacket());
        }

        return null;
    }
}
