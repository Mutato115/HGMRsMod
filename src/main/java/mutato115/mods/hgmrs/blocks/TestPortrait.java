package mutato115.mods.hgmrs.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mutato115.mods.hgmrs.registries.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class TestPortrait extends BlockDoor {
	
	private boolean justOnce = false;
	

	public TestPortrait() {
		super(Material.wood);
		this.setBlockTextureName("hgmrsmod:eagle_bronze_knocker");
		this.setBlockName("test_portrait");
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

	
	private void func_150011_b(int p_150011_1_) {
        float f = 0.1875F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
        int j = p_150011_1_ & 3;
        boolean flag = (p_150011_1_ & 4) != 0;
        boolean flag1 = (p_150011_1_ & 16) != 0;
        if (j == 0) {
            if (flag) {
                if (!flag1) {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, f);
                } else {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 4.0F, 1.0F);
                }
            } else {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 4.0F, 1.0F);
            }
        } else if (j == 1) {
            if (flag) {
                if (!flag1) {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
                } else {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 4.0F, 1.0F);
                }
            } else {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, f);
            }
        } else if (j == 2) {
            if (flag) {
                if (!flag1) {
                    this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 4.0F, 1.0F);
                } else {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 4.0F, f);
                }
            } else {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
            }
        } else if (j == 3) {
            if (flag) {
                if (!flag1) {
                    this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 4.0F, 1.0F);
                } else {
                    this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 4.0F, 1.0F);
                }
            } else {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 4.0F, 1.0F);
            }
        }

    }
	
}
