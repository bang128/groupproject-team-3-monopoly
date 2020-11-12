package starter;
import java.util.*;


public class goToJail extends Items{
	Level l;
	public goToJail() {
		name = "goToJail";
	}

	@Override
	public void visit (Character Player) {
		System.out.println("You have been sent to jail and your two turn is skipped.");
		for(int i=0; i<=1; i++) {
		Player.setMove(false);
		Player.setPosition(new Space(0, l.getnCols() -1));
		}
	}
}
