package mutato115.mods.hgmrs.tiles;

import io.netty.buffer.ByteBuf;
import mutato115.mods.hgmrs.json.UniquePosition;
import mutato115.mods.hgmrs.lib.Log;
import mutato115.mods.hgmrs.registries.BlockRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TeBarrel extends TileEntity {

    private TeBarrel master;
    private boolean isMaster;
    private boolean firstRun = true;
    
    private int currentPower = 0;
    private int timer = 0;
    
    private List<UniquePosition> rhythm;
    private List<TeBarrel> multiBlockBarrels;

    @Override
    public Block getBlockType() {
    	return BlockRegistry.barrel;
    }
    
    public boolean isMaster() {
        return isMaster;
    }

    public TeBarrel getMaster() {
        initializeMultiblockIfNecessary();
        return master;
    }

    private void setMaster(TeBarrel master, int barrels) {
        this.master = master;
        boolean wasMaster = isMaster;
        isMaster = master == this;
        if(isMaster) {
            Log.info("Master set to " + barrels + " blocks");
        } else if(!isMaster && wasMaster) {
            
        }
    }

    @Override
    public void updateEntity() {
        super.updateEntity();
        if(firstRun) {
            initializeMultiblockIfNecessary();
            firstRun = false;
        }
        
        if (isMaster) {
        	if (this.getTimer() % 4 == 0) {
        		this.decreasePowerInMultiblock(worldObj);
        	}
        	this.decreaseTimerForAll();
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
        for(ForgeDirection d : ForgeDirection.VALID_DIRECTIONS) {
            TileEntity te = worldObj.getTileEntity(xCoord + d.offsetX, yCoord + d.offsetY, zCoord + d.offsetZ);
            if(te instanceof TeBarrel) {
                ((TeBarrel)te).master = null;
                ((TeBarrel)te).initializeMultiblockIfNecessary();
            }
        }
    }

    private void initializeMultiblockIfNecessary() {
        if(master == null || master.isInvalid()) {
            List<TeBarrel> connectedBarrels = new ArrayList<TeBarrel>();
            Stack<TeBarrel> traversingBarrels = new Stack<TeBarrel>();
            TeBarrel master = this;
            traversingBarrels.add(this);
            while(!traversingBarrels.isEmpty()) {
                TeBarrel barrel = traversingBarrels.pop();
                if(barrel.isMaster()) {
                    master = barrel;
                }
                if (!connectedBarrels.contains(barrel)) {
                	connectedBarrels.add(barrel);
                }
                for(ForgeDirection d : ForgeDirection.VALID_DIRECTIONS) {
                    TileEntity te = worldObj.getTileEntity(barrel.xCoord + d.offsetX, barrel.yCoord + d.offsetY, barrel.zCoord + d.offsetZ);
                    if(te instanceof TeBarrel && !connectedBarrels.contains(te)) {
                        traversingBarrels.add((TeBarrel)te);
                    }
                }
            }
            Log.info("Setting master to " + master.xCoord + ", " + master.yCoord + ", " + master.zCoord + " for " + connectedBarrels.size() + " blocks");
            for(TeBarrel barrel : connectedBarrels) {
                barrel.setMaster(master, connectedBarrels.size());
            }
            master.setBarrels(new ArrayList<TeBarrel>(connectedBarrels));
        }
    }

    public void onGuiButtonPress(int id) {

    }

    public void writeToPacket(ByteBuf buf) {

    }

    public void readFromPacket(ByteBuf buf) {
    	
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);

        isMaster = tag.getBoolean("isMaster");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);

        tag.setBoolean("isMaster", isMaster);
    }
    
    public List<UniquePosition> getRhythm() {
    	return isMaster ? this.rhythm : getMaster().getRhythm();
    }
    
    public List<TeBarrel> getBarrels() {
    	return isMaster ? this.multiBlockBarrels : getMaster().getBarrels();
    }
    
    public void setBarrels(List<TeBarrel> barrels) {
    	this.multiBlockBarrels = barrels;
    }
    
    public int getProvidedPower() {
    	return currentPower;
    }
    
    public void setProvidedPower(int power) {
    	this.currentPower = power;
    }
    
    public void setPowerForAll(int power, World world) {
    	if (isMaster) {
    		for (TeBarrel barrel : this.multiBlockBarrels) {
    			barrel.setProvidedPower(power);
    			world.notifyBlocksOfNeighborChange(barrel.xCoord, barrel.yCoord, barrel.zCoord, BlockRegistry.barrel);
    		}
    	} else {
    		getMaster().setPowerForAll(power, world);
    	}
    }
    
    public void decreasePowerInMultiblock(World world) {
    	if (this.getProvidedPower() > 0) {
    		if (isMaster) {
        		for (TeBarrel barrel : this.multiBlockBarrels) {
        			barrel.decreasePower(world);
        		}
        	} else {
        		getMaster().decreasePowerInMultiblock(world);
        	}
    	}
    }
    
    private void decreasePower(World world) {
    	this.currentPower--;
    	world.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
    }
    
    public int getTimer() {
    	return this.timer;
    }
    
    private void resetTimer() {
    	this.timer = 60;
    }
    
    private void decreaseTimerForAll() {
    	if (isMaster) {
    		for (TeBarrel barrel : this.multiBlockBarrels) {
    			barrel.decreaseTimer();
    		}
    	} else {
    		getMaster().decreaseTimerForAll();
    	}
    }
    
    private void decreaseTimer() {
    	this.timer--;
    }

}