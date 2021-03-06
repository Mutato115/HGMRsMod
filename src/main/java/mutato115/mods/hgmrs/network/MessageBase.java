package mutato115.mods.hgmrs.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import mutato115.mods.hgmrs.HGMRsMod;
import net.minecraft.entity.player.EntityPlayer;

public abstract class MessageBase<REQ extends IMessage> implements IMessage, IMessageHandler<REQ, REQ>{

    @Override
    public REQ onMessage(REQ message, MessageContext ctx) {
        if(ctx.side == Side.SERVER) {
            handleServerSide(message, ctx.getServerHandler().playerEntity);
        } else {
            handleClientSide(message, HGMRsMod.proxy.getClientPlayer());
        }
        return null;
    }

    
    public abstract void handleClientSide(REQ message, EntityPlayer player);

    
    public abstract void handleServerSide(REQ message, EntityPlayer player);
}
