package mutato115.mods.hgmrs.items;

import mutato115.mods.hgmrs.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.StatCollector;

public class ItemBarrel extends ItemBlock {

	public ItemBarrel(Block block) {
		super(block);
		this.setCreativeTab(CreativeTabs.tabRedstone);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack p_77653_1_) {
        return "" + EnumChatFormatting.YELLOW + EnumChatFormatting.BOLD + "Hufflepuff: " + EnumChatFormatting.RESET + EnumChatFormatting.YELLOW + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name");
    }

}
