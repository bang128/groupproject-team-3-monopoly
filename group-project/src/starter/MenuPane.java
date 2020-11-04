package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
									 // all of the GraphicsProgram calls
	//private GButton play_button;
	//private GButton quit_button;
	private GLabel label;
	private GImage play;
	private GImage quit;
	private GImage icon;
	
	
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		label = new GLabel("Welcome to Monopoly", 150, 300);
		label.setFont("Comic Sans MS-40");
		/*play_button = new GButton("Play Game", (MainApplication.WINDOW_WIDTH/2) - 100, 400, 200, 75);
		play_button.setFillColor(Color.GREEN);
		quit_button = new GButton("Quit Application",(MainApplication.WINDOW_WIDTH/2) - 100, 500, 200, 75);
		quit_button.setFillColor(Color.RED);*/
		play = new GImage("play_button.png", (MainApplication.WINDOW_WIDTH/2) - 100, 400);
		quit = new GImage("quit_button.png", (MainApplication.WINDOW_WIDTH/2) - 100, 550);
		icon = new GImage("icon.png", 10, 10);
		icon.setSize(150, 150);
	}

	@Override
	public void showContents() {
		program.add(play);
		program.add(quit);
		program.add(label);
		program.add(icon);
	}

	@Override
	public void hideContents() {
		program.remove(play);
		program.remove(quit);
		program.remove(label);
		program.remove(icon);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == play) {
			program.switchToGraphicsGame();
		}
		if (obj == quit) {
			System.exit(0);
		}
	}
}
