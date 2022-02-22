package mutato115.mods.hgmrs.blocks;

import mutato115.mods.hgmrs.tiles.TeBarrel;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
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

}
