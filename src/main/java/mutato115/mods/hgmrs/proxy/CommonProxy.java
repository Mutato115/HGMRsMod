package mutato115.mods.hgmrs.proxy;

import java.io.File;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import mutato115.mods.hgmrs.event.Listener;
import mutato115.mods.hgmrs.network.EntrancePacketToClient;
import mutato115.mods.hgmrs.network.EntrancePacketToServer;
import mutato115.mods.hgmrs.registries.BlockRegistry;
import mutato115.mods.hgmrs.registries.ItemRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import sun.rmi.runtime.Log;

public class CommonProxy {
	
	
	private static SimpleNetworkWrapper netWrapper;
	
	File modWorldDir;

	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
		BlockRegistry.createBlocks();
    	ItemRegistry.createItems();
    	
    	BlockRegistry.registerBlocks();
    	ItemRegistry.registerItems();
    	
    	
    	this.netWrapper = NetworkRegistry.INSTANCE.newSimpleChannel("HGMRsEntrancePackets");
    	
    	this.netWrapper.registerMessage(EntrancePacketToClient.class, EntrancePacketToClient.class, 0, Side.CLIENT);
    	this.netWrapper.registerMessage(EntrancePacketToServer.class, EntrancePacketToServer.class, 1, Side.SERVER);
    }
    
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	MinecraftForge.EVENT_BUS.register(new Listener());
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }

    
    
    public void createConfigInWorldDir(World world) {}
    
    public File getConfigDir() {return modWorldDir;}
    
    
    public void say() {}
	
    
    public SimpleNetworkWrapper getNetworkWrapper() {
    	return netWrapper;
    }
    
    public EntityPlayer getClientPlayer() {return null;}
    
    
}
