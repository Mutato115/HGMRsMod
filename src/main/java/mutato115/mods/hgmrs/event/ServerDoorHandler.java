package mutato115.mods.hgmrs.event;

import mutato115.mods.hgmrs.registries.BlockRegistry;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class ServerDoorHandler {

	public static boolean openDoor(EntityPlayer player, int x, int y, int z) {
		World world = player.getEntityWorld();
		
		int i1 = ((BlockDoor) BlockRegistry.eagleBronzeKnocker).func_150012_g(world, x, y, z);
        int j1 = i1 & 7;
        j1 ^= 4;
        if ((i1 & 8) == 0) {
            world.setBlockMetadataWithNotify(x, y, z, j1, 2);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        } else {
            world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
            world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
        }

        world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
        world.playSoundAtEntity(player, "random.door_open", 1, 1);
        return true;
	}

}
