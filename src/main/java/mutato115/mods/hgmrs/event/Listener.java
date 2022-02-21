package mutato115.mods.hgmrs.event;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import mutato115.mods.hgmrs.HGMRsMod;
import net.minecraftforge.event.world.ExplosionEvent;
import net.minecraftforge.event.world.WorldEvent;

public class Listener {
	
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		HGMRsMod.mod.proxy.createConfigInWorldDir(event.world);
	}

}
