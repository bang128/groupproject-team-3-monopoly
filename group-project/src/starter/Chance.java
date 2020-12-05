package starter;
import java.util.Random;
import java.util.*;

public class Chance extends Items {
	
	public Chance() {
		name = "chance";
	}

	@Override
	public int visit (Character Player) {
		if(Player.isMove()) {
			Random r = new Random();
			int r_2 = r.nextInt();
			if (r_2 % 2 == 0) return loseMoney(Player);
			else return winMoney(Player);
		}
		return 0;
		
	}
	public int loseMoney(Character Player) {
		 Random r = new Random();
		 int r_2 = r.nextInt(100);
		 Object[] options = { "OK" };
			boolean choice = handleOption(options, "Chance", "Oops! Your chance card says that you lose $" + r_2, "chance_v_b.png");
			if (choice)
				Player.setMoney(Player.getMoney() - r_2);
			return r_2;
	}

	public int winMoney(Character Player) {
		Random r = new Random();
		int r_1=r.nextInt(100) ;
		 Object[] options = { "OK" };
			boolean choice = handleOption(options, "Chance", "Wonderful! Your chance card says that you win $" + r_1, "chance_v_b.png");
			if (choice)
				Player.setMoney(Player.getMoney() + r_1);
			return -r_1;
	}

}
 