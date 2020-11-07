package starter;
import java.util.Random;

import java.util.*;

public class dice {
	private String name;
	private int total=0;
	private int d_1=0;
	private int d_2=0;
	boolean same = true ;
	private int totalSame=0;
	
	
	
	public dice() {
		setName("dice");
	}
	
	public int total() {
		Random dice1 = new Random();
		 d_1=dice1.nextInt(6) + 1;
		Random dice2 = new Random();
		 d_2=dice2.nextInt(6) + 1;
		return total=d_1+d_2;
	
	}
	
	public void bothDicesSame() {
		if (d_1==d_2) {
			same=true;
			totalSame+=1;
		}
		else {
				same=false;
				totalSame=0;
		}
	}
	
	public void gotToJail() {
		if (totalSame==3) {
			System.out.println("You have been sent to jail.");
		}
	}
	public static void main(String[] args) {
		dice d= new dice();
		System.out.println("total:"+d.total()+"\ndice1: "+d.d_1+"\ndice2:"+d.d_2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
