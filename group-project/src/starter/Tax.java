package starter;

import java.util.Random;

public class Tax extends Items {
	public Tax() {
		name = "tax";
	}
	
	@Override
	public void visit (Character Player) {
		 System.out.println("You are landed on the tax property, and you have to pay $100");
		 Player.setMoney(Player.getMoney() - 100);	
	}
}
