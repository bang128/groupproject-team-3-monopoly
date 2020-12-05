package starter;
import java.util.*;


public class goToJail extends Items{
	public goToJail() {
		name = "goToJail";
	}

	@Override
	public int visit (Character Player) {
		if(Player.isMove()) {
			Object[] options = {"Yes", "No"};
			boolean choice = handleOption(options, "Go to Jail", "You are being sent to Jail. Would you like to pay $100 to be released?", "go_to_jail.png");
			if (choice) {
				Player.setMoney(Player.getMoney() - 100);
				return 100;
			}
			else {
				Player.setMove(false);
				return 0;
			}
		}
		return 0;
	}
}
