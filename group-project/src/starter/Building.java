package starter;

public class Building extends Items {
	private Character owner;
	
	public Building() {
		symbol = 'b';
		owner = new Character(CharacterType.NONAME, 0,0,0,false);
	}
	public Building(char s, Character o) {
		symbol = s;
		owner = o;
	}
	
	public void setOwner(Character o) {owner = o;}
	public Character getOwner() { return owner;}
	
	@Override
	public void visit(Character player) {
		if (owner == new Character(CharacterType.NONAME, 0,0,0,false)) {
			Object[] options = { "Yes", "No" };
			boolean choice = handleOption(options, "Empty Property", "This is an empty property. Would you like to buy it? $500");
			if (choice) {
				player.setMoney(player.getMoney() - 500);
				setOwner(player);
				
			}
		}
	}
}
