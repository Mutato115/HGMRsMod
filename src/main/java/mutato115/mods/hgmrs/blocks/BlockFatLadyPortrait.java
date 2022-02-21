package mutato115.mods.hgmrs.blocks;

import mutato115.mods.hgmrs.tiles.TeFatLadyPortrait;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFatLadyPortrait extends BlockContainer {
	
	
	public IIcon tex;
	
	
	public BlockFatLadyPortrait() {
		super(Material.carpet);

		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.setBlockName("fat_lady_portrait");
		this.setStepSound(this.soundTypeCloth);
		this.setHardness(1.0f);

	}

	
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TeFatLadyPortrait();
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister icon) {
		tex = icon.registerIcon("hgmrsmod:fat_lady_portrait_item");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		return tex;
	}
	
	@Override
	public boolean isCollidable() {
		return true;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack) {
        byte b0 = 0;
        int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (l == 0) {
            b0 = 2;
            world.getBlock(x, y, z).setBlockBounds(0.0f, 0.0f, 0.375f, 1.0f, 2.0f, 0.625f);
        }

        if (l == 1) {
            b0 = 5;
            world.getBlock(x, y, z).setBlockBounds(0.375f, 0.0f, 0.0f, 0.625f, 2.0f, 1.0f);
        }

        if (l == 2) {
            b0 = 3;
            world.getBlock(x, y, z).setBlockBounds(0.0f, 0.0f, 0.375f, 1.0f, 2.0f, 0.625f);
        }

        if (l == 3) {
            b0 = 4;
            world.getBlock(x, y, z).setBlockBounds(0.375f, 0.0f, 0.0f, 0.625f, 2.0f, 1.0f);
        }

        world.setBlockMetadataWithNotify(x, y, z, b0, 2);
    }
	
	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        this.setDeafultDirectrion(world, x, y, z);
    }
	
	private void setDeafultDirectrion(World world, int x, int y, int z) {
        if (!world.scheduledUpdatesAreImmediate) {
            Block b1 = world.getBlock(x, y, z - 1);
            Block b2 = world.getBlock(x, y, z + 1);
            Block b3 = world.getBlock(x - 1, y, z);
            Block b4 = world.getBlock(x + 1, y, z);
            byte b5 = 3;
            if (b1.func_149730_j() && !b2.func_149730_j()) {
                b5 = 3;
            }

            if (b2.func_149730_j() && !b1.func_149730_j()) {
                b5 = 2;
            }

            if (b3.func_149730_j() && !b4.func_149730_j()) {
                b5 = 5;
            }

            if (b4.func_149730_j() && !b3.func_149730_j()) {
                b5 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, b5, 2);
        }

    }
	

}
