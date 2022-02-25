package mutato115.mods.hgmrs.json;

import java.util.List;

public class Rhythm {
	
	private UniquePosition[] rhythm;
	
	public Rhythm() {}
	
	public Rhythm(UniquePosition[] barrelRhythm) {
		this.rhythm = barrelRhythm;
	}
	
	public UniquePosition[] getRhythm() {
		return this.rhythm;
	}
	
	public void setRhythm(UniquePosition[] barrelRhythm) {
		this.rhythm = barrelRhythm;
	}

}
