package mutato115.mods.hgmrs.proxy;

import java.io.File;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import mutato115.mods.hgmrs.HGMRsMod;
import mutato115.mods.hgmrs.config.WorldConfigHandler;
import mutato115.mods.hgmrs.lib.Log;
import mutato115.mods.hgmrs.registries.BlockRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraftforge.event.world.WorldEvent;

public class ClientProxy extends CommonProxy {
	
	private Log log = HGMRsMod.mod.getLogger();
	
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	super.preInit(event);
    	
    	BlockRegistry.registerRenders();
    }
    
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		super.init(event);
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	super.postInit(event);
    	
    	log.info("Initialized HGMR's Mod on Client!");
    }
    
    
    
    public void createConfigInWorldDir(World world) {
    	if (Minecraft.getMinecraft().isSingleplayer()) {
			World iWorld = Minecraft.getMinecraft().getIntegratedServer().worldServerForDimension(world.provider.dimensionId);
        	ISaveHandler wsh = iWorld.getSaveHandler();
        	
        	File modDir = new File(wsh.getWorldDirectory(), "HGMRs");
        	
        	WorldConfigHandler.createFiles(modDir);
        	
        	this.modWorldDir = modDir;
    	}
    }
    
    
    
    public void say() {
    	log.info("Client!");
    }
    
    
    @Override
    public EntityPlayer getClientPlayer() {
    	return Minecraft.getMinecraft().thePlayer;
    }

}
