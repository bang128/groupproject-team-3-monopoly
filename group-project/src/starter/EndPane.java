package starter;

import java.awt.Color;

import acm.graphics.*;

public class EndPane extends GraphicsPane {
	private MainApplication program;
	private GLabel label;
	private GImage Image;
	private Character player;
	private Level l;
	private GLabel winner, loser;
	private GRect rect, rect1;
	private GLine line;
	
	
	
	public EndPane(MainApplication app) {
		super();
		program = app;
		MainApplication.continue_game = false;
		label = new GLabel("GAME OVER", 250, 200);	
		label.setFont("Comic Sans MS-Bold-35");
		label.setColor(new Color(153, 0, 51));
		
	}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(label);
		//System.out.println(MainApplication.winner);
		//System.out.println(MainApplication.loser);
		rect = new GRect(1, 300, 700, 200);
		rect1 = new GRect(1, 400, 700, 100);
		rect.setColor(new Color(215, 240, 247));
		rect.setFilled(true);
		rect.setFillColor(Color.LIGHT_GRAY);
		rect.sendBackward();
		program.add(rect);
		winner = new GLabel("Winner:\t\t\t" + MainApplication.winner.getType().toString(), 50,350);
		loser = new GLabel("Loser:\t\t\t" + MainApplication.loser.getType().toString(), 50,450);
		//winner.setColor(Color.orange);
		//loser.setColor(Color.yellow);
		winner.setFont("Arial-24");
		loser.setFont("Arial-24");
		program.add(winner);
		program.add(loser);
		line = new GLine(1, 400, 700, 400);
		program.add(line);
		if(MainApplication.winner.getType()==CharacterType.PLAYER1) {
			winner.setColor(Color.YELLOW);
			loser.setColor(Color.orange);
		}
		else if(MainApplication.loser.getType()==CharacterType.PLAYER1){
			loser.setColor(Color.yellow);
			winner.setColor(Color.orange);
		}
	}



	

	@Override
	public void hideContents() {
		program.remove(label);
		program.remove(winner);
		program.remove(loser);
		program.remove(rect);
		program.remove(line);
		// TODO Auto-generated method stub
		
	}
	

	
}
