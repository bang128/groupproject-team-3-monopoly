package starter;

public class Building extends Items {
	private Character owner;
	
	public Building() {
		name = "empty";
	}
	public Building(String n, Character o) {
		name = n;
		owner = o;
	}
	
	@Override
	public int visit(Character player) {
		if(player.isMove()) {
			if (getOwner() == null) {
				Object[] options = { "Yes", "No" };
				boolean choice = handleOption(options, "Empty Property", "This is an empty property. Would you like to buy it? $200", "empty_v_b.png");
				if (choice) {
					player.setMoney(player.getMoney() - 200);
					setOwner(player);
					setName(player.getType().toString() + "_owned");
					return 200;
				}
			}
			else if (getOwner() != player && getOwner() != null) {
				Object[] options = {"OK"};
				boolean choice = handleOption(options, "Building", "You have to pay $50 for the owner of this building.", "owned_v_b.png");
				if (choice) {
					player.setMoney(player.getMoney() - 50);
					return 50;
				}
			}
		}
		return 0;
	}
}
