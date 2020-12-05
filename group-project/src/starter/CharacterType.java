package starter;

public enum CharacterType {
	PLAYER1, PLAYER2;
	
	public String toString() {
		switch(this) {
			case PLAYER1: return "Player1";
			case PLAYER2: return "Player2";
		}
		return "n/a";
	}
}
