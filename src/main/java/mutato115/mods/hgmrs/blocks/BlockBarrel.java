package mutato115.mods.hgmrs.blocks;

import java.util.Random;

import mutato115.mods.hgmrs.tiles.TeBarrel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBarrel extends BlockContainer {

	public BlockBarrel() {
		super(Material.wood);
		
		this.setCreativeTab(CreativeTabs.tabRedstone);
		this.setBlockName("barrel");
		this.setStepSound(this.soundTypeWood);
		this.setHardness(1.0f);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TeBarrel();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if (world.getTileEntity(x, y, z) instanceof TeBarrel) {
			TeBarrel barrel = (TeBarrel) world.getTileEntity(x, y, z);
			
			barrel.setPowerForAll(15, world);
			world.notifyBlocksOfNeighborChange(x, y, z, this);
		}

		return true;
	}
	

	@Override
	public boolean canProvidePower() {
		return true;
	}
	
	@Override
	public int isProvidingWeakPower(IBlockAccess iba, int x, int y, int z, int meta) {
        if (iba.getTileEntity(x, y, z) instanceof TeBarrel) {
        	return ((TeBarrel) iba.getTileEntity(x, y, z)).getProvidedPower();
        } else {
        	return 0;
        }
    }

 
	@Override
    public int isProvidingStrongPower(IBlockAccess iba, int x, int y, int z, int meta) {
		if (iba.getTileEntity(x, y, z) instanceof TeBarrel) {
        	return ((TeBarrel) iba.getTileEntity(x, y, z)).getProvidedPower();
        } else {
        	return 0;
        }
    }

}
