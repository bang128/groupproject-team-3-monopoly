package starter;

public class Building extends Items {
	private Character owner;
	
	public Building() {
		symbol = 'b';
		owner = null;
	}
	public Building(char s, Character o) {
		symbol = s;
		owner = o;
	}
	
	public void setOwner(Character o) {owner = o;}
	
	public Character getOwner() { return owner;}
	
	public void visit(Character player) {
		if (owner == null) {
			Object[] options = { "Yes", "No" };
			boolean choice = handleOption(options, "Empty Property", "This is an empty property. Would you like to buy it? $500");
			if (choice) {
				player.setMoney(player.getMoney() - 500);
				setOwner(player);	
			}
			else System.exit(0);
		}
		else if (owner != player && owner != null) {
			Object[] options = {"OK"};
			boolean choice = handleOption(options, "Building", "You have to pay $50 for the owner of this building.");
			if (choice) {
				player.setMoney(player.getMoney() - 50);
			}
		}
	}
}
