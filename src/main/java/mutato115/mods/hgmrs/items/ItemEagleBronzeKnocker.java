package mutato115.mods.hgmrs.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mutato115.mods.hgmrs.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemEagleBronzeKnocker extends ItemDoor {

	public ItemEagleBronzeKnocker() {
		super(Material.wood);
		this.setUnlocalizedName("eagle_bronze_knocker");
		this.setTextureName("hgmrsmod:eagle_bronze_knocker");
	}
	
	
	@Override
	public boolean onItemUse(ItemStack p_onItemUse_1_, EntityPlayer p_onItemUse_2_, World p_onItemUse_3_, int p_onItemUse_4_, int p_onItemUse_5_, int p_onItemUse_6_, int p_onItemUse_7_, float p_onItemUse_8_, float p_onItemUse_9_, float p_onItemUse_10_) {
		if (p_onItemUse_7_ != 1) {
            return false;
        } else {
            ++p_onItemUse_5_;
            Block var11 = BlockRegistry.eagleBronzeKnocker;

            if (p_onItemUse_2_.canPlayerEdit(p_onItemUse_4_, p_onItemUse_5_, p_onItemUse_6_, p_onItemUse_7_, p_onItemUse_1_) && p_onItemUse_2_.canPlayerEdit(p_onItemUse_4_, p_onItemUse_5_ + 1, p_onItemUse_6_, p_onItemUse_7_, p_onItemUse_1_)) {
                if (!var11.canPlaceBlockAt(p_onItemUse_3_, p_onItemUse_4_, p_onItemUse_5_, p_onItemUse_6_)) {
                    return false;
                } else {
                    int var12 = MathHelper.floor_double((double)((p_onItemUse_2_.rotationYaw + 180.0F) * 4.0F / 360.0F) - 0.5D) & 3;
                    placeDoorBlock(p_onItemUse_3_, p_onItemUse_4_, p_onItemUse_5_, p_onItemUse_6_, var12, var11);
                    --p_onItemUse_1_.stackSize;
                    return true;
                }
            } else {
                return false;
            }
        }
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack p_77653_1_) {
        return ("" + EnumChatFormatting.BLUE + EnumChatFormatting.BOLD + "Ravenclaw: " + EnumChatFormatting.RESET + EnumChatFormatting.BLUE + StatCollector.translateToLocal(this.getUnlocalizedNameInefficiently(p_77653_1_) + ".name")).trim();
    }
	
}
