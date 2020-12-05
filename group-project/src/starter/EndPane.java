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
	private GRect rect;
	private GLine line;
	
	
	
	public EndPane(MainApplication app) {
		super();
		program = app;
		MainApplication.continue_game = false;
		label = new GLabel("GAME OVER", 250, 200);	
		label.setFont("Arial-28");
		
		
	}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(label);
		System.out.println(MainApplication.winner);
		System.out.println(MainApplication.loser);
		winner = new GLabel(MainApplication.winner.getType().toString()+"		Winner", 50,350);
		loser = new GLabel(MainApplication.loser.getType().toString()+"			Loser", 50,450);
		winner.setColor(Color.orange);
		loser.setColor(Color.yellow);
		winner.setFont("Arial-24");
		loser.setFont("Arial-24");
		program.add(winner);
		program.add(loser);
		rect = new GRect(0, 300, 700, 200);
		program.add(rect);
		line = new GLine(0, 410, 700, 400);
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
