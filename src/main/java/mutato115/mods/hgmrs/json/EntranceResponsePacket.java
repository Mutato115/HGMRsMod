package mutato115.mods.hgmrs.json;

public class EntranceResponsePacket {

	private UniquePosition position;
	
	
	public EntranceResponsePacket(UniquePosition position) {
		this.position = position;
	}


	public UniquePosition getPosition() {
		return position;
	}

	public void setPosition(UniquePosition position) {
		this.position = position;
	}
	
}
