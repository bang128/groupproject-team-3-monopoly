package starter;

public enum CharacterType {
	PLAYER1, PLAYER2, NONAME;
	
	public String toString() {
		switch(this) {
			case PLAYER1: return "player1";
			case PLAYER2: return "player2";
			case NONAME: return"no name";
		}
		return "n/a";
	}
}
