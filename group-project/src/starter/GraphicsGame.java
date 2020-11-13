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
	public static final int DICE_SIZE = 100;
	public static final int[] MONEY_LABEL_X = {20, BOARD_WIDTH - 70};
	public static final int MONEY_LABEL_Y = BOARD_HEIGHT + INVENTORY_HEIGHT/2 + 30;
	public static final String LABEL_FONT = "Arial-Bold-22";
	public static final String TURN_FONT = "Arial-Bold-30";
	public static final String EXIT_SIGN = "EXIT";
	public static final String IMG_FILENAME_PATH = "images/";
	public static final String IMG_EXTENSION = ".png";
	
	private Level level = new Level(11,11);
	private GDimension special = new GDimension(SPECIAL_WIDTH -1, SPECIAL_HEIGHT - 1);
	private GDimension normal_vertical = new GDimension(SpaceWidth() - 1, SPECIAL_HEIGHT - 1);
	private GDimension normal_horizontal = new GDimension(SPECIAL_WIDTH - 1, SpaceHeight() - 1);
	private Items[][] board = level.getBoard();
	private MainApplication program;
	private GImage dice1 = new GImage("dice.png", BOARD_WIDTH/2 - 125, BOARD_HEIGHT/2 - 50);
	private GImage dice2 = new GImage("dice.png", BOARD_WIDTH/2 + 25, BOARD_HEIGHT/2 - 50);
	private GImage dices_icon = new GImage("dices_icon.png", BOARD_WIDTH/2 - 100 ,BOARD_HEIGHT/2 - 50);
	private ArrayList<String> dices = new ArrayList<String>();
	private dice d = new dice();
	private boolean click_dices = false;
	int num1 = 0;
	int num2 = 0;
	private ArrayList<GImage> players = new ArrayList<GImage>();
	private GLabel turn_label = new GLabel(level.getTurn().getType().toString().toUpperCase(), BOARD_WIDTH/2 -80, BOARD_HEIGHT + INVENTORY_HEIGHT/2 + 20);
	private ArrayList<GLabel> money_label = new ArrayList<GLabel>();	
	
	public GraphicsGame(MainApplication app) {
		this.program = app;
		dices.add("dice.png");
		dices.add("dice1.png");
		dices.add("dice2.png");
		dices.add("dice3.png");
		dices.add("dice4.png");
		dices.add("dice5.png");
		dices.add("dice6.png");
		players.add(new GImage("player1.png", level.characters.get(0).getCol() * SpaceWidth() + SPECIAL_WIDTH - 15, level.characters.get(0).getRow() * SpaceHeight() + SPECIAL_HEIGHT - 40));
		players.add(new GImage("player2.png", level.characters.get(1).getCol() * SpaceWidth() + SPECIAL_WIDTH - 15, level.characters.get(1).getRow() * SpaceHeight() + SPECIAL_HEIGHT));
		money_label.add(new GLabel(""+level.characters.get(0).getMoney(), MONEY_LABEL_X[0], MONEY_LABEL_Y));
		money_label.add(new GLabel(""+level.characters.get(0).getMoney(), MONEY_LABEL_X[1], MONEY_LABEL_Y));	
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
		GLabel l = new GLabel("Turn:", BOARD_WIDTH/2, BOARD_HEIGHT + INVENTORY_HEIGHT/3);
		l.setFont(LABEL_FONT);
		l.setLocation(l.getX() - l.getWidth()/2 - 10, l.getY());
		turn_label.setFont(TURN_FONT);
		turn_label.setColor(new Color(255, 26, 26));
		program.add(turn_label);
		program.add(l);
		for(int i = 0; i < 2; i++) {
			GLabel p = new GLabel(level.characters.get(i).getType().toString().toUpperCase(), MONEY_LABEL_X[i] - i*50, MONEY_LABEL_Y - 50);
			p.setFont(LABEL_FONT);
			program.add(p);
			money_label.get(i).setFont(LABEL_FONT);
			program.add(money_label.get(i));
		}
		program.add(MainApplication.returnButton);
	}
	public void drawDices() {
		dice1.setSize(DICE_SIZE, DICE_SIZE);
		dice2.setSize(DICE_SIZE, DICE_SIZE);
		dices_icon.setSize(200, 130);
		program.add(dices_icon);
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
			GImage pic_bottom = new GImage(name_bottom + "_v_b.png",SPECIAL_WIDTH + (c-1)*SpaceWidth() + 1, BOARD_HEIGHT - SPECIAL_HEIGHT + 1);
			pic_bottom.setSize(normal_vertical);
			program.add(pic_bottom);	
		}
	}
	public void drawAllBoard() {
		drawGrid();
		drawItems();
		drawDices();
		drawCharacter();
		drawInventories();
	}

	
	@Override
	public void mousePressed(MouseEvent e) {
		if(program.getElementAt(e.getX(), e.getY()) == dices_icon && !click_dices) {
			num1 = d.getDice1();
			num2 = d.getDice2();
			dice1.setImage(dices.get(num1));
			dice2.setImage(dices.get(num2));
			program.remove(dices_icon);
			program.add(dice1);
			program.add(dice2);
			click_dices = true;
		}	
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(click_dices) {
			program.pause(500);
//			System.out.println(level.getTurn().getPosition());
//			if(!level.checkInJail(level.getTurn())) {
//			}
			level.moveNumSpaces(num1 + num2);
			level.checkInJail();
			d.bothDicesSame(level.getTurn());
			level.getBoardAt(level.getTurn().getRow(), level.getTurn().getCol()).visit(level.getTurn());
			if (level.getTurn().getType() == level.characters.get(0).getType()) moveImage(0);
			else moveImage(1);
			System.out.println("Player 1: "+level.characters.get(0).getMoney() + " " + level.characters.get(0).getSame());
			System.out.println("Player 2: "+level.characters.get(1).getMoney() + " " + level.characters.get(1).getSame()+"\n");
			num1 = 0; num2 = 0;
			program.pause(500);
			program.remove(dice1);
			program.remove(dice2);
			program.add(dices_icon);
			level.changeTurn();
			turn_label.setLabel(level.getTurn().getType().toString().toUpperCase());
			click_dices = false;
		}
	}
	
	@Override 
	public void mouseClicked(MouseEvent e) {
		if(program.getElementAt(e.getX(), e.getY()) == MainApplication.returnButton) { 
			MainApplication.continue_game = true;
			program.switchToMenu();
		}
	}
	public void moveImage(int i) {
		location(players.get(i), level.getTurn());
		SetOwnedBuilding(players.get(i), level.getTurn());
		money_label.get(i).setLabel("" + level.characters.get(i).getMoney());
	}
	
	public void SetOwnedBuilding(GImage i, Character c) {
		if (level.getBoardAt(c.getRow(), c.getCol()).getName() == "owned") {
			program.remove(program.getElementAt(i.getX() - 5, i.getY() - 5));
			GImage o = null;
			if(c.getRow() == 0) {
				o = new GImage("owned_v_t.png", SPECIAL_WIDTH + (c.getCol()-1)*SpaceWidth() + 1, 1);
				o.setSize(normal_vertical);
				program.add(o);
			}
			else if (c.getRow() == level.getnRows() - 1) { 
				o = new GImage("owned_v_b.png", SPECIAL_WIDTH + (c.getCol()-1)*SpaceHeight() + 1, BOARD_WIDTH - SPECIAL_WIDTH + 1);
				o.setSize(normal_vertical);
			}
			else if (c.getCol() == 0) {
				o = new GImage("owned_h_l.png", 1, SPECIAL_HEIGHT + (c.getRow()-1)*SpaceHeight() + 1);
				o.setSize(normal_horizontal);
			}
			else if (c.getCol() == level.getnCols() - 1) {
				o = new GImage("owned_h_r.png", BOARD_WIDTH - SPECIAL_WIDTH + 1, SPECIAL_HEIGHT + (c.getRow()-1)*SpaceHeight() + 1);
				o.setSize(normal_horizontal);
			}
			program.add(o);
			o.sendToBack();
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
		//program.addMouseListeners();
	}
	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.removeAll();
		
	}


}
