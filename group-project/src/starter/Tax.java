package starter;

import java.util.Random;

public class Tax extends Items {
	public Tax() {
		name = "tax";
	}
	
	@Override
	public void visit (Character Player) {
		Object[] options = { "OK" };
		boolean choice = handleOption(options, "Tax", "You are landing on the tax station. You have to pay $100.");
		if (choice) {
			Player.setMoney(Player.getMoney() - 100);
		}	
	}
}
