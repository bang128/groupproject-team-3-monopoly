package starter;

import java.util.Random;

public class Tax extends Items {
	public Tax() {
		name = "tax";
	}
	
	@Override
	public int visit(Character Player) {
		if(Player.isMove()) {
			Object[] options = { "OK" };
			boolean choice = handleOption(options, "Tax", "You are landing on the tax station. You have to pay $100.", "tax_v_b.png");
			if (choice) {
				Player.setMoney(Player.getMoney() - 100);
			}
			return 100;
		}
		return 0;
	}
}
