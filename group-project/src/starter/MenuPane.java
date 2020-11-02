package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GButton play_button;
	private GButton quit_button;
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		play_button = new GButton("Play Game", (MainApplication.WINDOW_WIDTH/2) - 100, 200, 200, 75);
		play_button.setFillColor(Color.RED);
		quit_button = new GButton("Quit Application",(MainApplication.WINDOW_WIDTH/2) - 100, 300, 200, 75);
		
	}

	@Override
	public void showContents() {
		program.add(play_button);
		program.add(quit_button);
	}

	@Override
	public void hideContents() {
		program.remove(play_button);
		program.remove(quit_button);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play_button) {
			program.switchToSome();
		}
		if (obj == quit_button) {
			System.exit(0);
		}
	}
}
