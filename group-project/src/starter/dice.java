package starter;
import java.util.Random;

import java.util.*;

public class dice {
	private String name;
	private int total=0;
	private int d_1=0;
	private int d_2=0;
	private int totalSame=0;
	
	public dice() {
		setName("dice");
	}
	

	public int total() { //Roll the dice
		return getDice1()+getDice2();
	}

	public int getDice1() {
		Random r = new Random();
		d_1 = r.nextInt(6) + 1;
		return d_1;
	}
	public int getDice2() {
		Random r = new Random();
		d_2 = r.nextInt(6) + 1;
		return d_2;
	}
	
	public void bothDicesSame(Character player) {
		if (d_1==d_2) {
			player.setSame(player.getSame() + 1);
		}
		else {
			player.setSame(0);
		}
	}
	
	
	public static void main(String[] args) {
		dice d= new dice();
		d.total = 0;
		System.out.println("total:"+d.total()+"\ndice1: "+d.d_1+"\ndice2:"+d.d_2);
		System.out.println(d.totalSame);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
