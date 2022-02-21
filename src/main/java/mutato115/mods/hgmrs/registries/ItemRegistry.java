package mutato115.mods.hgmrs.registries;

import cpw.mods.fml.common.registry.GameRegistry;
import mutato115.mods.hgmrs.items.ItemEagleBronzeKnocker;
import mutato115.mods.hgmrs.items.ItemTestPortrait;
import net.minecraft.item.Item;

public class ItemRegistry {
	
	
	public static Item eagleBronzeKnocker;
	public static Item testPortrait;

	
	public static void createItems() {
		
		eagleBronzeKnocker = new ItemEagleBronzeKnocker();
		testPortrait = new ItemTestPortrait();
		
	}
	
	public static void registerItems() {
		
		GameRegistry.registerItem(eagleBronzeKnocker, eagleBronzeKnocker.getUnlocalizedName().substring(5));
		//GameRegistry.registerItem(testPortrait, testPortrait.getUnlocalizedName().substring(5));
		
	}
	
	
}
