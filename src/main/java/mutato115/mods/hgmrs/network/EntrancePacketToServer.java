package mutato115.mods.hgmrs.network;

import com.google.gson.Gson;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import mutato115.mods.hgmrs.event.ServerDoorHandler;
import mutato115.mods.hgmrs.json.EntranceResponsePacket;
import mutato115.mods.hgmrs.json.UniquePosition;
import mutato115.mods.hgmrs.lib.HGMRStatic;
import net.minecraft.entity.player.EntityPlayer;

public class EntrancePacketToServer extends MessageBase<EntrancePacketToServer> {
	
	
	private HGMRStatic.House house;
	private boolean mayOpen;
	private EntranceResponsePacket json;
	private Gson g = new Gson();
	
	
	public EntrancePacketToServer() {}
	
	public EntrancePacketToServer(HGMRStatic.House house, boolean mayOpen, EntranceResponsePacket content) {
		this.house = house;
		this.mayOpen = mayOpen;
		this.json = content;
	}
	
	public HGMRStatic.House getHouse() {return this.house;}
	public EntranceResponsePacket getPacket() {return this.json;}
	public boolean mayOpen() {return this.mayOpen;}
	
	

	@Override
	public void fromBytes(ByteBuf buf) {
		this.house = HGMRStatic.House.values()[buf.readInt()];
		this.mayOpen = buf.readBoolean();
		this.json = g.fromJson(ByteBufUtils.readUTF8String(buf), EntranceResponsePacket.class);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.house.ordinal());
		buf.writeBoolean(this.mayOpen);
		ByteBufUtils.writeUTF8String(buf, g.toJson(this.json));
	}

	@Override
	public void handleClientSide(EntrancePacketToServer message, EntityPlayer player) {}

	@Override
	public void handleServerSide(EntrancePacketToServer message, EntityPlayer player) {
		if (message.mayOpen) {
			UniquePosition position = message.getPacket().getPosition();
			ServerDoorHandler.openDoor(player, position.getX(), position.getY(), position.getZ());
		}
	}

}
