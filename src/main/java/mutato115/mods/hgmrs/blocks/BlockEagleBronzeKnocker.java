package mutato115.mods.hgmrs.blocks;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mutato115.mods.hgmrs.HGMRsMod;
import mutato115.mods.hgmrs.config.WorldConfigHandler;
import mutato115.mods.hgmrs.json.EntrancePacket;
import mutato115.mods.hgmrs.json.Question;
import mutato115.mods.hgmrs.json.Questions;
import mutato115.mods.hgmrs.json.UniquePlayer;
import mutato115.mods.hgmrs.json.UniquePosition;
import mutato115.mods.hgmrs.lib.HGMRStatic;
import mutato115.mods.hgmrs.network.EntrancePacketToClient;
import mutato115.mods.hgmrs.registries.ItemRegistry;
import mutato115.mods.hgmrs.utils.HGMRUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.storage.ISaveHandler;
import net.minecraft.world.storage.WorldInfo;

public class BlockEagleBronzeKnocker extends BlockDoor {
	

	public BlockEagleBronzeKnocker() {
		super(Material.wood);
		this.setBlockTextureName("hgmrsmod:eagle_bronze_knocker");
		this.setBlockName("eagle_bronze_knocker_block");
		this.setStepSound(soundTypeWood);
	}
	
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
        return ItemRegistry.eagleBronzeKnocker;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return ItemRegistry.eagleBronzeKnocker;
    }
	
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
        
		
		if (world.isRemote) {
			
			return false;
	        
		} else {
			
			Questions questions = WorldConfigHandler.getQuestions(new File(HGMRsMod.proxy.getConfigDir(), "ravenclaw.json"));
			
			UniquePosition position = new UniquePosition(x, y, z);
			UniquePlayer p = new UniquePlayer(player.getGameProfile().getId().toString(), player.getDisplayName());
			Question question = questions.getRandomQuestion();
			EntrancePacket packet = new EntrancePacket(p, position, question);
			
			HGMRsMod.proxy.getNetworkWrapper().sendTo(new EntrancePacketToClient(HGMRStatic.House.RAVENCLAW, packet), (EntityPlayerMP) player);
			
	        return true;
		
		}

    }

}
