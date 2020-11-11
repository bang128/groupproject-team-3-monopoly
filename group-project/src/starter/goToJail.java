package starter;
import java.util.*;


public class goToJail extends Items{
	
	public goToJail() {
		name = "goToJail";
	}

	@Override
	public void visit (Character Player) {
		System.out.println("You have been sent to jail and your two turn is skipped.");
		for(int i=0; i<=1; i++) {
		Player.setMove(false);}
	}
}
