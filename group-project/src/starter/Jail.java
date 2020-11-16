package starter;

public class Jail extends Items{
	public Jail() {
		name = "jail";
	}
	
	@Override 
	public int visit(Character player) {
		if(!player.isMove()) {
			Object[] options = {"Yes", "No"};
			boolean choice = handleOption(options, "Jail", "You are now in jail. Would you like to pay $100 to be released?");
			if (choice) {
				player.setMoney(player.getMoney() - 100);
				player.setMove(true);
				return 100;
			}
		}
		return 0;
	}
	
}
