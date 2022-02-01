package starter;

import java.awt.*;
import acm.graphics.*;

public class InstructionPane extends GraphicsPane {
	private MainApplication program;
	private GImage content;
	private GLabel label;
	private final String font = "Comic Sans MS-Bold-35";
	
	public InstructionPane(MainApplication app) {
		super();
		program = app;
		label = new GLabel("Instruction", MainApplication.WINDOW_WIDTH/2 - 90, 90);
		label.setFont(font);
		label.setColor(new Color(153, 0, 51));
		content = new GImage("content.png", 40, 140);

	}
	


	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(content);
		program.add(label);
		//program.addSomeButtons();
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub	
		program.remove(content);
		program.remove(label);
		//program.removeSomeButtons();
	}
}
