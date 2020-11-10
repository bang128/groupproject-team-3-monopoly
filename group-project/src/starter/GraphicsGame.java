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
	private MainApplication program;
	private GImage dice1;
	private GImage dice2;
	private ArrayList<String> dices;
	private dice d;
	private boolean click_dice1 = false;
	private boolean click_dice2 = false;
	int num1 = 0;
	int num2 = 0;
	private ArrayList<GImage> players;
	
	
	public GraphicsGame(MainApplication app) {
		this.program = app;
		level = new Level(11, 11);
		special = new GDimension(SPECIAL_WIDTH -1, SPECIAL_HEIGHT - 1);
		normal_vertical = new GDimension(SpaceWidth() - 1, SPECIAL_HEIGHT - 1);
		normal_horizontal = new GDimension(SPECIAL_WIDTH - 1, SpaceHeight() - 1);
		board = level.getBoard();
		d= new dice();
		dice1 = new GImage("dice.png", BOARD_WIDTH/2 - 125, BOARD_HEIGHT/2 - 50);
		dice1.setSize(100,100);
		dice2 = new GImage("dice.png", BOARD_WIDTH/2 + 25, BOARD_HEIGHT/2 - 50);
		dice2.setSize(100,100);
		dices = new ArrayList<String>();
		dices.add("dice.png");
		dices.add("dice1.png");
		dices.add("dice2.png");
		dices.add("dice3.png");
		dices.add("dice4.png");
		dices.add("dice5.png");
		dices.add("dice6.png");
		players = new ArrayList<GImage>();
		players.add(new GImage("player1.png", level.characters.get(0).getCol() * SpaceWidth() + SPECIAL_WIDTH - 15, level.characters.get(0).getRow() * SpaceHeight() + SPECIAL_HEIGHT - 40));
		players.add(new GImage("player2.png", level.characters.get(1).getCol() * SpaceWidth() + SPECIAL_WIDTH - 15, level.characters.get(1).getRow() * SpaceHeight() + SPECIAL_HEIGHT));
		
	}
	private double SpaceHeight() {
		return (BOARD_HEIGHT - 2*SPECIAL_HEIGHT + 1)/(level.getnRows() - 2);
	}
	private double SpaceWidth() {
		return (BOARD_WIDTH - 2*SPECIAL_WIDTH + 1)/(level.getnCols() - 2);
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
	public void drawCharacter() {
		for (int i = 0; i < 2; i++) {program.add(players.get(i));}
	}
	public void drawInventories() {
		
	}
	public void drawDices() {
		program.add(dice1);
		program.add(dice2);
	}

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
	public void drawAllBoard() {
		drawGrid();
		drawItems();
		drawDices();
		drawCharacter();
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.print(dices + "\n");
		if(program.getElementAt(e.getX(), e.getY()) == dice1 && !click_dice1) {
			System.out.println("DICE 1:");
			click_dice1 = true;
			num1 = d.getDice1();
			System.out.print(num1 + " " + num2 + "\n");
			dice1.setImage(dices.get(num1));
			System.out.print(dices.get(num1) + "\n");
		}
		if(program.getElementAt(e.getX(), e.getY()) == dice2 && !click_dice2) {
			System.out.println("DICE 2:");
			click_dice2 = true;
			num2 = d.getDice2();
			System.out.println(num1 + " " + num2);
			dice2.setImage(dices.get(num2));
			System.out.print(dices.get(num2) + "\n");
		}
		
		
	}
	public void mouseReleased(MouseEvent e) {
		if(click_dice1 && click_dice2) {
			program.pause(500);
			System.out.print(level.getTurn().getPosition());
			level.moveNumSpaces(num1 + num2);
			if (level.getTurn().getType() == level.characters.get(0).getType())
				location(players.get(0), level.getTurn());
			else location(players.get(1), level.getTurn());
			System.out.print(level.getTurn().getPosition());
			level.getBoardAt(level.getTurn().getRow(), level.getTurn().getCol()).visit(level.getTurn());
			System.out.println(level.characters.get(0).getMoney());
			num1 = 0; num2 = 0;
			program.pause(1000);
			dice1.setImage("dice.png");
			dice2.setImage("dice.png");
			click_dice1 = false;
			click_dice2 = false;
			level.changeTurn();
			
		}
	}

	public void location(GImage i, Character c) {
		double x = 0;
		double y = 0;
		if (c.getRow() == 0 || c.getRow() == level.getnRows() - 1) {
			if (c.getRow() == 0) y = SPECIAL_HEIGHT/2 - i.getHeight()/2;
			else y = BOARD_HEIGHT - SPECIAL_HEIGHT/2 - i.getHeight()/2;
			
			if (c.getCol() == 0) x = SPECIAL_WIDTH/2 - i.getWidth()/2;
			else if (c.getCol() == level.getnCols() - 1) x = BOARD_WIDTH - SPECIAL_WIDTH/2 - i.getWidth()/2;
			else x = SPECIAL_WIDTH + (c.getCol() - 0.5)*SpaceWidth() - i.getWidth()/2;
		}
		
		else {
			if (c.getCol() == 0) x = SPECIAL_WIDTH/2 - i.getWidth()/2;
			else x = BOARD_WIDTH - SPECIAL_WIDTH/2 - i.getWidth()/2;
			
			y = SPECIAL_HEIGHT + (c.getRow() - 0.5)*SpaceHeight() - i.getHeight()/2;
		}
		i.setLocation(x, y);
		
	}
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		drawAllBoard();
		program.addMouseListeners();
	}
	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		
	}


}
