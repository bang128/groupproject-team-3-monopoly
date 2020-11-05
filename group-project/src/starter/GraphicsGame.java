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
	private GDimension special;
	private GDimension normal_vertical;
	private GDimension normal_horizontal;
	private Items[][] board;
	private Character turn;
	private MainApplication program;

	
	public GraphicsGame(MainApplication app) {
		this.program = app;
		level = new Level(11, 11);
		special = new GDimension(SPECIAL_WIDTH -1, SPECIAL_HEIGHT - 1);
		normal_vertical = new GDimension(SpaceWidth() - 1, SPECIAL_HEIGHT - 1);
		normal_horizontal = new GDimension(SPECIAL_WIDTH - 1, SpaceHeight() - 1);
		board = level.getBoard();
		Random generator = new Random();
		int r = generator.nextInt();
		if (r % 2 == 0) turn = level.characters.get(0);
		else turn = level.characters.get(1);
		
	}
	private double SpaceHeight() {
		return (BOARD_HEIGHT - 2*SPECIAL_HEIGHT + 1)/(level.getnRows() - 2);
	}
	private double SpaceWidth() {
		return (BOARD_WIDTH - 2*SPECIAL_WIDTH + 1)/(level.getnCols() - 2);
	}
	public Space convertXYToSpace(double x, double y) {
		return new Space(0,0);
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

	public void drawItems() {
		GImage go_pic = new GImage("go.png", BOARD_WIDTH - SPECIAL_WIDTH + 1, BOARD_HEIGHT - SPECIAL_HEIGHT + 1);
		go_pic.setSize(special);
		program.add(go_pic);
		GImage jail_pic = new GImage("jail.png", 1, BOARD_HEIGHT - SPECIAL_HEIGHT + 1);
		jail_pic.setSize(special);
		program.add(jail_pic);
		GImage go_to_jail_pic = new GImage("go_to_jail.png", BOARD_WIDTH - SPECIAL_WIDTH + 1, 1);
		go_to_jail_pic.setSize(special);
		program.add(go_to_jail_pic);
		GImage parking_pic = new GImage("parking.png", 1, 1);
		parking_pic.setSize(special);
		program.add(parking_pic);
		for (int r = 1; r < level.getnRows() - 1; r++) {
			String name_left = board[r][0].getName();
			GImage pic_left = new GImage(name_left + "_h_l.png", 1, SPECIAL_HEIGHT + (r-1)*SpaceHeight() + 1);
			pic_left.setSize(normal_horizontal);
			program.add(pic_left);
			String name_right = board[r][level.getnCols() - 1].getName();
			GImage pic_right = new GImage(name_right + "_h_r.png", BOARD_WIDTH - SPECIAL_WIDTH + 1, SPECIAL_HEIGHT + (r-1)*SpaceHeight() + 1);
			pic_right.setSize(normal_horizontal);
			program.add(pic_right);	
		}
		
		for (int c = 1; c < level.getnCols() - 1; c++) {
			String name_top = board[0][c].getName();
			GImage pic_top = new GImage(name_top + "_v_t.png", SPECIAL_WIDTH + (c-1)*SpaceWidth() + 1, 1);
			pic_top.setSize(normal_vertical);
			program.add(pic_top);
			String name_bottom = board[level.getnRows() - 1][c].getName();
			GImage pic_bottom = new GImage(name_bottom + "_v_b.png",SPECIAL_HEIGHT + (c-1)*SpaceHeight() + 1, BOARD_HEIGHT - SPECIAL_HEIGHT + 1);
			pic_bottom.setSize(normal_vertical);
			program.add(pic_bottom);	
		}
	}
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
		drawItems();
	}
	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}
	
	

}
