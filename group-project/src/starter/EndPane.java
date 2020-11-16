package starter;

import acm.graphics.*;

public class EndPane extends GraphicsPane {
	private MainApplication program;
	private GLabel l;
	
	public EndPane(MainApplication app) {
		super();
		program = app;
		program.continue_game = false;
		l = new GLabel("GAME OVER", program.WINDOW_WIDTH/2, program.WINDOW_HEIGHT/2);
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
