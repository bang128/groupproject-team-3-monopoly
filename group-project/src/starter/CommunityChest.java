package starter;
import java.util.Random;
import java.util.*;

public class CommunityChest extends Items {
	public CommunityChest() {
		name = "cc";
	}

	@Override
	public int visit (Character Player) {
		Random r = new Random();
		int r_1=r.nextInt(100);
		Object[] options = { "Yes", "No" };
		boolean choice = handleOption(options, "Community Chest", "Your Community Chest card says you can get $" + r_1 + ". Would you like to get it?", "cc_v_b.png");
		if (choice) {
			Player.setMoney(Player.getMoney() + r_1);	
			return -r_1;
		}
		return 0;
	}
}
