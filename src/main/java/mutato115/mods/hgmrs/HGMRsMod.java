package mutato115.mods.hgmrs;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import mutato115.mods.hgmrs.event.Listener;
import mutato115.mods.hgmrs.lib.Log;
import mutato115.mods.hgmrs.proxy.CommonProxy;
import mutato115.mods.hgmrs.registries.BlockRegistry;
import mutato115.mods.hgmrs.registries.ItemRegistry;

@Mod(modid = HGMRsMod.MODID, version = HGMRsMod.VERSION)
public class HGMRsMod {
	
    public static final String MODID = "hgmrsmod";
    public static final String NAME = "HGMR's Mod";
    public static final String VERSION = "0.1";
    
    @Instance
    public static HGMRsMod mod = new HGMRsMod();
    
    @SidedProxy(clientSide = "mutato115.mods.hgmrs.proxy.ClientProxy", serverSide = "mutato115.mods.hgmrs.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    private static Log log = new Log();
    
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	proxy.preInit(event);
    }
    
    
    @EventHandler
    public void init(FMLInitializationEvent event) {
		proxy.init(event);
    }
    
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	proxy.postInit(event);
    }
    
    
    public Log getLogger() {
    	return log;
    }
    
}
