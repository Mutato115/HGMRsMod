package mutato115.mods.hgmrs.network;

import com.google.gson.Gson;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import mutato115.mods.hgmrs.HGMRsMod;
import mutato115.mods.hgmrs.gui.GuiRavenclaw;
import mutato115.mods.hgmrs.json.EntrancePacket;
import mutato115.mods.hgmrs.json.UniquePosition;
import mutato115.mods.hgmrs.lib.HGMRStatic;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class EntrancePacketToClient extends MessageBase<EntrancePacketToClient> {
	
	
	private HGMRStatic.House house;
	private EntrancePacket json;
	private Gson g = new Gson();
	
	
	public EntrancePacketToClient() {}
	
	public EntrancePacketToClient(HGMRStatic.House house, EntrancePacket content) {
		this.house = house;
		this.json = content;
	}
	
	public HGMRStatic.House getHouse() {return this.house;}
	public EntrancePacket getPacket() {return this.json;}

	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.house = HGMRStatic.House.values()[buf.readInt()];
		this.json = g.fromJson(ByteBufUtils.readUTF8String(buf), EntrancePacket.class);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.house.ordinal());
		ByteBufUtils.writeUTF8String(buf, g.toJson(this.json));
	}

	
	@Override
	@SideOnly(Side.CLIENT)
	public void handleClientSide(EntrancePacketToClient message, EntityPlayer player) {
		HGMRsMod.mod.getLogger().info("New Entrance Packet:  " + message.getHouse() + "   +   " + message.getPacket().getQuestion().toString());
		UniquePosition doorPosition = message.getPacket().getPosition();
		Minecraft.getMinecraft().displayGuiScreen(new GuiRavenclaw(message.getPacket().getQuestion(), doorPosition.getX(), doorPosition.getY(), doorPosition.getZ()));
	}

	@Override
	public void handleServerSide(EntrancePacketToClient message, EntityPlayer player) {}
	

}
