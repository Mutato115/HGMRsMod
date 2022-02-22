package mutato115.mods.hgmrs.registries;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mutato115.mods.hgmrs.blocks.BlockBarrel;
import mutato115.mods.hgmrs.blocks.BlockEagleBronzeKnocker;
import mutato115.mods.hgmrs.blocks.BlockFatLadyPortrait;
import mutato115.mods.hgmrs.blocks.TestPortrait;
import mutato115.mods.hgmrs.items.ItemEagleBronzeKnocker;
import mutato115.mods.hgmrs.tiles.RenderFatLadyPortrait;
import mutato115.mods.hgmrs.tiles.TeFatLadyPortrait;
import net.minecraft.block.Block;

public class BlockRegistry {
	
	
	public static Block fatLadyPortrait;
	public static Block eagleBronzeKnocker;
	public static Block testPortrait;
	public static Block barrel;
	
	
	public static void createBlocks() {
		
		fatLadyPortrait = new BlockFatLadyPortrait();
		eagleBronzeKnocker = new BlockEagleBronzeKnocker();
		testPortrait = new TestPortrait();
		barrel = new BlockBarrel();
		
	}
	
	public static void registerBlocks() {
		
		//GameRegistry.registerBlock(fatLadyPortrait, fatLadyPortrait.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(eagleBronzeKnocker, eagleBronzeKnocker.getUnlocalizedName().substring(5));
		//GameRegistry.registerBlock(testPortrait, testPortrait.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(barrel, barrel.getUnlocalizedName().substring(5));
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void registerRenders() {
		//GameRegistry.registerTileEntity(TeFatLadyPortrait.class, "fat_lady_portrait");
		//ClientRegistry.bindTileEntitySpecialRenderer(TeFatLadyPortrait.class, new RenderFatLadyPortrait());
	}

	
}
