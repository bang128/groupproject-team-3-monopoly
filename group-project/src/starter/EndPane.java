package starter;

import acm.graphics.*;

public class EndPane extends GraphicsPane {
	private MainApplication program;
	private GLabel l;
	
	public EndPane(MainApplication app) {
		super();
		program = app;
		MainApplication.continue_game = false;
		l = new GLabel("GAME OVER", MainApplication.WINDOW_WIDTH/2, MainApplication.WINDOW_HEIGHT/2);
	}
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(l);
		
	}

	@Override
	public void hideContents() {
		program.remove(l);
		// TODO Auto-generated method stub
		
	}
}
