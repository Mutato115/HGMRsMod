package mutato115.mods.hgmrs.items;

import mutato115.mods.hgmrs.registries.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemTestPortrait extends ItemDoor {

	public ItemTestPortrait() {
		super(Material.wood);
		this.setUnlocalizedName("test_portrait_item");
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

}
