package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 700;
	public static final int WINDOW_HEIGHT = 900;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };
	
	private SomePane somePane;
	private MenuPane menu;
	private GraphicsGame graphicsGame;
	private EndPane endPane;
	private InstructionPane instructionPane;
	private int count;
	
	public static boolean continue_game = false;
	public static GImage sound_on = new GImage("sound_on.png", 10, WINDOW_HEIGHT - 40);
	public static GImage sound_off = new GImage("sound_off.png", 10, WINDOW_HEIGHT - 40);
	public static GButton returnButton = new GButton("Return to Menu", WINDOW_WIDTH - 100, WINDOW_HEIGHT - 40, 90,
			30, new Color(102, 153, 255));
	public static GImage background = new GImage("background.png", 0, 0);

	public  static Character winner = new Character(CharacterType.PLAYER1, 0,0,0,true,0); 
	public static Character loser = new Character(CharacterType.PLAYER2, 0,0,0,true,0);
	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Welcome to Monopoly \n");
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		graphicsGame = new GraphicsGame(this);
		endPane = new EndPane(this);
		instructionPane = new InstructionPane(this);
		returnButton.setColor(new Color(0, 26, 77));
		switchToMenu();
		background.setSize(WINDOW_WIDTH + 10, WINDOW_HEIGHT + 10);
		
	}

	public void switchToMenu() {
		//playRandomSound();
		count++;
		switchToScreen(menu);
		add(background);
		background.sendToBack();
		add(sound_on);
	}

	public void switchToSome() {
		//playRandomSound();
		switchToScreen(somePane);
		addSomeButtons();
	}
	
	public void switchToGraphicsGame() {
		switchToScreen(graphicsGame);
		add(background);
		background.sendToBack();
		addSomeButtons();
	}
	
	public void switchToEnd() {
		switchToScreen(endPane);
		addSomeButtons();
		add(background);
		background.sendToBack();
	}
	public void switchToInstruction() {
		switchToScreen(instructionPane);
		add(background);
		background.sendToBack();
		addSomeButtons();
	}
	
	public void addSomeButtons() {
		add(returnButton);
		add(sound_on);
	}
	
	@Override 
	public void mouseClicked(MouseEvent e) {
		if(getElementAt(e.getX(), e.getY()) == MainApplication.returnButton) 
			switchToMenu();
	}
	
	private void PlayRandomSound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
	}
//	private void playRandomSound() {
//		AudioPlayer audio = AudioPlayer.getInstance();
//		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
//	}
}
