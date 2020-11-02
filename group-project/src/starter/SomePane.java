package starter;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GObject;

public class SomePane extends GraphicsPane {
	private MainApplication program; // you will use program to get access to
										// all of the GraphicsProgram calls
	private GImage board;

	public SomePane(MainApplication app) {
		this.program = app;
		board = new GImage("BoardPic.jpg", 100, 100);

	}

	@Override
	public void showContents() {
		program.add(board);
	}

	@Override
	public void hideContents() {
		program.remove(board);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		if (obj == board) {
			program.switchToMenu();
		}
	}
}
