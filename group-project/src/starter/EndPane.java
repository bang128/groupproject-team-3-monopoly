package starter;

import java.awt.Color;

import acm.graphics.*;

public class EndPane extends GraphicsPane {
	private MainApplication program;
	private GLabel label;
	private GLabel winner, loser;
	private GRect rect;
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
		rect = new GRect(1, 300, MainApplication.WINDOW_WIDTH - 3, 200);
		rect.setColor(new Color(215, 240, 247));
		rect.setFilled(true);
		rect.setFillColor(new Color(153, 179, 230));
		rect.sendBackward();
		program.add(rect);
		winner = new GLabel("Winner:  " + MainApplication.winner.getType().toString(), MainApplication.WINDOW_WIDTH/2 - 90,350);
		loser = new GLabel("Loser:   " + MainApplication.loser.getType().toString(), MainApplication.WINDOW_WIDTH/2 - 90,450);
		
		winner.setFont("Arial-Bold-24");
		loser.setFont("Arial-Bold-24");
		program.add(winner);
		program.add(loser);
		line = new GLine(1, 400, 700, 400);
		line.setColor(new Color(215, 240, 247));
		program.add(line);
		if(MainApplication.winner.getType()==CharacterType.PLAYER1) {
			winner.setColor(Color.yellow);
			loser.setColor(new Color(255, 128, 0));
		}
		else if(MainApplication.loser.getType()==CharacterType.PLAYER1){
			winner.setColor(new Color(255, 128, 0));
			loser.setColor(Color.yellow);
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
