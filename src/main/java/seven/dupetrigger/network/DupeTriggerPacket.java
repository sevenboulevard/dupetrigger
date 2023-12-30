package seven.dupetrigger.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class DupeTriggerPacket implements IMessage {

    // Add any necessary fields to represent the data you want to send

    public DupeTriggerPacket() {
        // Required default constructor
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        // Read data from the packet
    }

    @Override
    public void toBytes(ByteBuf buf) {
        // Write data to the packet
    }
}
