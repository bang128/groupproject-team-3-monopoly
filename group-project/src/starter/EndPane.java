package starter;

import acm.graphics.*;

public class EndPane extends GraphicsPane {
	private MainApplication program;
	private GLabel label;
	private GImage Image;
	private Character player;
	private Level l;
	private GLabel winner, loser;
	
	
	public EndPane(MainApplication app) {
		super();
		program = app;
		MainApplication.continue_game = false;
		label = new GLabel("GAME OVER", 400, 400);	
		label.setFont("Arial-24");
		
		
	}

	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(label);
		System.out.println(MainApplication.winner);
		System.out.println(MainApplication.loser);
		winner = new GLabel(MainApplication.winner.getType().toString()+"Winner", 100,400);
		loser = new GLabel(MainApplication.loser.getType().toString()+"loser", 100,500);
		program.add(winner);
		program.add(loser);
		
		
	}

	@Override
	public void hideContents() {
		program.remove(label);
		// TODO Auto-generated method stub
		
	}
	

	
}
