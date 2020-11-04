package starter;
import acm.program.*;
import acm.graphics.*;
import java.util.*; 
import java.awt.*;
import java.awt.event.*;

public class GraphicsGame extends GraphicsPane {
	public static final int BOARD_WIDTH = 700;
	public static final int BOARD_HEIGHT = 700;
	public static final int INVENTORY_HEIGHT = 200;
	public static final int SPECIAL_HEIGHT = 90;
	public static final int SPECIAL_WIDTH = 90;
	public static final String lABEL_FONT = "Arial-Bold-22";
	public static final String EXIT_SIGN = "EXIT";
	public static final String IMG_FILENAME_PATH = "images/";
	public static final String IMG_EXTENSION = ".png";
	
	private Level level;
	
	private MainApplication program;

	
	public GraphicsGame(MainApplication app) {
		this.program = app;
		level = new Level(11, 11);
	}
	private double SpaceHeight() {
		return (BOARD_HEIGHT - 2*SPECIAL_HEIGHT + level.getnRows()/10)/(level.getnRows() - 2);
	}
	private double SpaceWidth() {
		return (BOARD_WIDTH - 2*SPECIAL_WIDTH + level.getnCols()/10)/(level.getnCols() - 2);
	}
	public Space convertXYToSpace(double x, double y) {
		return new Space(0,0);
	}
	public void drawMenu() {
		
	}
	public void drawGrid() {
		program.add(new GLine(SPECIAL_WIDTH, 0, SPECIAL_WIDTH, BOARD_HEIGHT));
		program.add(new GLine(BOARD_WIDTH - SPECIAL_WIDTH, 0, BOARD_WIDTH - SPECIAL_WIDTH, BOARD_HEIGHT));
		program.add(new GLine(0, SPECIAL_HEIGHT, BOARD_WIDTH, SPECIAL_HEIGHT));
		program.add(new GLine(0, BOARD_HEIGHT - SPECIAL_HEIGHT, BOARD_WIDTH, BOARD_HEIGHT - SPECIAL_HEIGHT));
		GLine border = new GLine(0, BOARD_HEIGHT, BOARD_WIDTH, BOARD_HEIGHT);
		border.setColor(Color.LIGHT_GRAY);
		program.add(border);
		for (int r = 1; r < level.getnRows() - 2; r++) {
			program.add(new GLine(0, SPECIAL_HEIGHT + r*SpaceHeight(), SPECIAL_WIDTH, SPECIAL_HEIGHT + r*SpaceHeight()));
			program.add(new GLine(BOARD_WIDTH - SPECIAL_WIDTH, SPECIAL_HEIGHT + r*SpaceHeight(), BOARD_WIDTH, SPECIAL_HEIGHT + r*SpaceHeight()));	
		}
		for (int c = 1; c < level.getnCols() - 2; c++) {
			program.add(new GLine(SPECIAL_WIDTH + c*SpaceWidth(),0 ,SPECIAL_WIDTH + c*SpaceWidth(), SPECIAL_HEIGHT));
			program.add(new GLine(SPECIAL_WIDTH + c*SpaceWidth(),BOARD_HEIGHT - SPECIAL_HEIGHT, SPECIAL_WIDTH + c*SpaceWidth(), BOARD_HEIGHT));
		}
	}
	public void drawCharacter() {}
	public void drawInventories() {
		
	}
	public void drawDices() {}
	public void drawChances() {}
	public void drawCommunityChest() {}
	public void drawItems() {}
	public void drawAllBoard() {}
	
	public int RollDice1() {
		Random generator = new Random();
		return generator.nextInt(6) + 1;
	}
	
	public int RollDice2() {
		Random generator = new Random();
		return generator.nextInt(6) + 1;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		drawGrid();
	}
	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
	
	

}
