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
		//System.out.println(MainApplication.winner);
		//System.out.println(MainApplication.loser);
		rect = new GRect(1, 300, 700, 200);
		rect.setColor(new Color(215, 240, 247));
		rect.setFilled(true);
		rect.setFillColor(Color.DARK_GRAY);
		rect.sendBackward();
		program.add(rect);
		winner = new GLabel("Winner:   " + MainApplication.winner.getType().toString(), 50,350);
		loser = new GLabel("Loser:   " + MainApplication.loser.getType().toString(), 50,450);
		winner.setColor(Color.orange);
		loser.setColor(Color.yellow);
		winner.setFont("Arial-24");
		loser.setFont("Arial-24");
		program.add(winner);
		program.add(loser);
		
		line = new GLine(1, 400, 700, 400);
		program.add(line);
		
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
