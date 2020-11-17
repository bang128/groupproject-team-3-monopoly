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
		//System.out.println("Owner: " + owner);
		if(player.isMove()) {
			if (getOwner() == null) {
				Object[] options = { "Yes", "No" };
				boolean choice = handleOption(options, "Empty Property", "This is an empty property. Would you like to buy it? $200");
				if (choice) {
					player.setMoney(player.getMoney() - 200);
					setOwner(player);
					setName("owned");
					//System.out.println("Owner: " + getOwner());
					return 200;
				}
			}
			else if (getOwner() != player && getOwner() != null) {
				Object[] options = {"OK"};
				boolean choice = handleOption(options, "Building", "You have to pay $50 for the owner of this building.");
				if (choice) {
					player.setMoney(player.getMoney() - 50);
					//System.out.println("Owner: " + owner);
					return 50;
				}
			}
			//System.out.println("Owner: " + getOwner());
		}
		return 0;
	}
}
