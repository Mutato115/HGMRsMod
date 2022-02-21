package mutato115.mods.hgmrs.json;

public class EntrancePacket {
	
	
	private UniquePlayer player;
	private UniquePosition position;
	private Question question;
	
	
	public EntrancePacket(UniquePlayer player, UniquePosition position, Question question) {
		this.player = player;
		this.position = position;
		this.question = question;
	}


	public UniquePlayer getPlayer() {
		return player;
	}

	public void setPlayer(UniquePlayer player) {
		this.player = player;
	}

	public UniquePosition getPosition() {
		return position;
	}

	public void setPosition(UniquePosition position) {
		this.position = position;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
