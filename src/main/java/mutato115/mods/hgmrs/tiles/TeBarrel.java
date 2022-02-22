package mutato115.mods.hgmrs.tiles;

import io.netty.buffer.ByteBuf;
import mutato115.mods.hgmrs.lib.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TeBarrel extends TileEntity {

    private TeBarrel master;
    private boolean isMaster;
    private boolean firstRun = true;

    public boolean isMaster(){
        return isMaster;
    }

    public TeBarrel getMaster(){
        initializeMultiblockIfNecessary();
        return master;
    }

    private void setMaster(TeBarrel master, int barrels){
        this.master = master;
        boolean wasMaster = isMaster;
        isMaster = master == this;
        if(isMaster) {
            Log.info("Master set to " + barrels + " blocks");
        } else if(!isMaster && wasMaster) {
            
        }
    }

    @Override
    public void updateEntity(){
        super.updateEntity();
        if(firstRun) {
            initializeMultiblockIfNecessary();
            firstRun = false;
        }
    }

    @Override
    public void invalidate(){
        super.invalidate();
        for(ForgeDirection d : ForgeDirection.VALID_DIRECTIONS) {
            TileEntity te = worldObj.getTileEntity(xCoord + d.offsetX, yCoord + d.offsetY, zCoord + d.offsetZ);
            if(te instanceof TeBarrel) {
                ((TeBarrel)te).master = null;
                ((TeBarrel)te).initializeMultiblockIfNecessary();
            }
        }
    }

    private void initializeMultiblockIfNecessary(){
        if(master == null || master.isInvalid()) {
            List<TeBarrel> connectedBarrels = new ArrayList<TeBarrel>();
            Stack<TeBarrel> traversingBarrels = new Stack<TeBarrel>();
            TeBarrel master = this;
            traversingBarrels.add(this);
            while(!traversingBarrels.isEmpty()) {
                TeBarrel storage = traversingBarrels.pop();
                if(storage.isMaster()) {
                    master = storage;
                }
                connectedBarrels.add(storage);
                for(ForgeDirection d : ForgeDirection.VALID_DIRECTIONS) {
                    TileEntity te = worldObj.getTileEntity(storage.xCoord + d.offsetX, storage.yCoord + d.offsetY, storage.zCoord + d.offsetZ);
                    if(te instanceof TeBarrel && !connectedBarrels.contains(te)) {
                        traversingBarrels.add((TeBarrel)te);
                    }
                }
            }
            Log.info("Setting master to " + master.xCoord + ", " + master.yCoord + ", " + master.zCoord + " for " + connectedBarrels.size() + " blocks");
            for(TeBarrel storage : connectedBarrels) {
                storage.setMaster(master, connectedBarrels.size());
            }
        }
    }

    public void onGuiButtonPress(int id){

    }

    public void writeToPacket(ByteBuf buf){

    }

    public void readFromPacket(ByteBuf buf){
    	
    }

    @Override
    public void readFromNBT(NBTTagCompound tag){
        super.readFromNBT(tag);

        isMaster = tag.getBoolean("isMaster");
    }

    @Override
    public void writeToNBT(NBTTagCompound tag){
        super.writeToNBT(tag);

        tag.setBoolean("isMaster", isMaster);
    }

}