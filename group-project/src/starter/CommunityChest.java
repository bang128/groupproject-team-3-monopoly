package starter;
import java.util.Random;
import java.util.*;

public class CommunityChest extends Items {

@Override
public void visit (Character Player) {
		Random r = new Random();
		int r_1=r.nextInt(100) ;
		Object[] options = { "Yes", "No" };
		boolean choice = handleOption(options, "Community Chest", "This is change Community Chest. Would you like to get? $"+r_1);
		if (choice) {
			Player.setMoney(Player.getMoney() + r_1);	
		}
		else System.exit(0);
	}
}
