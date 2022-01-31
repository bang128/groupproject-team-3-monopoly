package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;
import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class MenuPane extends GraphicsPane {
	private final double button_width = MainApplication.WINDOW_WIDTH/2 -100;
	
	private MainApplication program; // you will use program to get access to
									 // all of the GraphicsProgram calls
	private GLabel label;
	private GImage start;
	private GImage cont;
	private GImage quit;
	private GImage icon;
	private GImage instruction;
	private GImage setting;
	
	public MenuPane(MainApplication app) {
		super();
		program = app;
		label = new GLabel("Welcome to Monopoly", 150, 200);
		label.setFont("Comic Sans MS-40");
		start = new GImage("start.png", button_width, 300);
		cont = new GImage("continue.png", button_width, 300);
		setting = new GImage("setting_button.png", button_width, 425);
		instruction = new GImage("instruction.png", button_width, 550);
		quit = new GImage("quit_button.png", button_width, 675);
		icon = new GImage("icon.png", 10, 10);
		icon.setSize(150, 150);
	}

	@Override
	public void showContents() {
		if(!MainApplication.continue_game) program.add(start);
		else program.add(cont);
		program.add(setting);
		program.add(instruction);
		program.add(quit);
		program.add(label);
		program.add(icon);
	}

	@Override
	public void hideContents() {
		program.remove(start);
		program.remove(cont);
		program.remove(setting);
		program.remove(instruction);
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
		if (obj == instruction) {
			program.switchToInstruction();
		}
		
		if (obj == setting) {
			program.switchToSetting();
		}
		
		if (obj == quit) {
			//System.out.println("Game Quit\n");
			System.exit(0);
		}
	}
}
