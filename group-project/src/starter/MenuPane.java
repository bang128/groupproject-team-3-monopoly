package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
									 // all of the GraphicsProgram calls
	private GLabel label;
	private GImage start;
	private GImage cont;
	private GImage quit;
	private GImage icon;
	
	
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		label = new GLabel("Welcome to Monopoly", 150, 300);
		label.setFont("Comic Sans MS-40");
		start = new GImage("start.png", (MainApplication.WINDOW_WIDTH/2) - 100, 400);
		cont = new GImage("continue.png", (MainApplication.WINDOW_WIDTH/2) - 100, 400);
		quit = new GImage("quit_button.png", (MainApplication.WINDOW_WIDTH/2) - 100, 550);
		icon = new GImage("icon.png", 10, 10);
		icon.setSize(150, 150);
	}

	@Override
	public void showContents() {
		if(!MainApplication.continue_game) program.add(start);
		else program.add(cont);
		program.add(quit);
		program.add(label);
		program.add(icon);
	}

	@Override
	public void hideContents() {
		program.remove(start);
		program.remove(cont);
		program.remove(quit);
		program.remove(label);
		program.remove(icon);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == start || obj == cont) {
			program.switchToGraphicsGame();
			//System.out.println("Game Started \n");
		}
		if (obj == quit) {
			//System.out.println("Game Quit\n");
			System.exit(0);
		}
	}
}
