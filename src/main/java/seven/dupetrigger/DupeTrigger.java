package seven.dupetrigger;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import seven.dupetrigger.network.DupeTriggerPacket;
import seven.dupetrigger.network.DupeTriggerPacketHandler;

@Mod(modid = DupeTrigger.MODID, version = DupeTrigger.VERSION, name = DupeTrigger.MODNAME)
public class DupeTrigger {

    public static final String MODID = "dupetrigger";
    public static final String VERSION = "0.7.4";
    public static final String MODNAME = "Dupe Trigger";

    public static DupeTrigger instance;
    public static SimpleNetworkWrapper networkWrapper;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        instance = this;

        // Initialize the network wrapper
        networkWrapper = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        networkWrapper.registerMessage(DupeTriggerPacketHandler.class, DupeTriggerPacket.class, 0, Side.SERVER);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        KeybindHandler.init();
        FMLCommonHandler.instance()
            .bus()
            .register(new KeybindEventHandler(networkWrapper));

        FMLLog.log(MODNAME, Level.INFO, "Dupe Trigger is ready.");
    }
}
