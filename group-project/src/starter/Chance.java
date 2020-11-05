package starter;
import java.util.Random;
import java.util.*;

public class Chance extends Items {
	
	public Chance() {
		name = "chance";
	}

	@Override
	public void visit (Character Player) {
		Random r = new Random();
		int r_2 = r.nextInt();
		if (r_2 % 2 == 0) loseMoney(Player);
		else winMoney(Player);
		
	}
	public void loseMoney(Character Player) {
		 Random r = new Random();
		 int r_2 = r.nextInt(100);
		 System.out.println("This is change chance card. you lost $"+r_2);
		 Player.setMoney(Player.getMoney() - r_2);	
	}

	public void winMoney(Character Player) {
		Random r = new Random();
		int r_1=r.nextInt(100) ;
		System.out.println("This is change chance card. you won $"+r_1);
		Player.setMoney(Player.getMoney() + r_1);	
	}

}
 