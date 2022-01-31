package starter;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;

public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 700;
	public static final int WINDOW_HEIGHT = 900;
	public static final String MUSIC_FOLDER = "sounds";
	//private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };
	
	private SomePane somePane;
	private MenuPane menu;
	private GraphicsGame graphicsGame;
	private EndPane endPane;
	private InstructionPane instructionPane;
	private SettingPane settingPane;
	private boolean AtEndPane = false;
	
	public static boolean continue_game = false;
	public static boolean isSoundOn = true;
	public static GImage sound_button = new GImage("sound_on.png", 10, WINDOW_HEIGHT - 40);
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
		settingPane = new SettingPane(this);
		graphicsGame = new GraphicsGame(this);
		endPane = new EndPane(this);
		instructionPane = new InstructionPane(this);
		returnButton.setColor(new Color(0, 26, 77));
		switchToMenu();
		background.setSize(WINDOW_WIDTH + 10, WINDOW_HEIGHT + 10);
		
	}
	

	public void switchToMenu() {
		//playRandomSound();
		AtEndPane = false;
		PlaySound();
		switchToScreen(menu);
		add(background);
		background.sendToBack();
		add(sound_button);
	}
	

	public void switchToSome() {
		//playRandomSound();
		AtEndPane = false;
		PlaySound();
		switchToScreen(somePane);
		addSomeButtons();
	}
	
	public void switchToGraphicsGame() {
		AtEndPane = false;
		PlaySound();
		switchToScreen(graphicsGame);
		add(background);
		background.sendToBack();
		addSomeButtons();
	}
	
	public void switchToEnd() {
		AtEndPane = true;
		PlaySound();
		switchToScreen(endPane);
		addSomeButtons();
		add(background);
		background.sendToBack();
	}
	public void switchToInstruction() {
		AtEndPane = false;
		PlaySound();
		switchToScreen(instructionPane);
		addSomeButtons();
		add(background);
		background.sendToBack();
	}
	
	public void switchToSetting() {
		AtEndPane = false;
		PlaySound();
		switchToScreen(settingPane);
		addSomeButtons();
		add(background);
		background.sendToBack();
	}
	
	public void addSomeButtons() {
		add(returnButton);
		add(sound_button);
	}
	
	public void removeSomeButtons() {
		remove(returnButton);
		remove(sound_button);
	}
	
	@Override 
	public void mouseClicked(MouseEvent e) {
		if(getElementAt(e.getX(), e.getY()) == MainApplication.returnButton) 
			switchToMenu();
		if(getElementAt(e.getX(), e.getY()) == MainApplication.sound_button) {
			if(isSoundOn) {
				sound_button.setImage("sound_off.png");
				isSoundOn = false;
				PlaySound();
			}
			else {
				sound_button.setImage("sound_on.png");
				isSoundOn = true;
				PlaySound();
			}
		}
	}
	
	private void PlaySound() {
		AudioPlayer audio = AudioPlayer.getInstance();
		if(isSoundOn && !AtEndPane) {
			audio.stopSound("sound", "end.mp3");
			audio.playSound("sound", "game.mp3");
		}
		else if (isSoundOn && AtEndPane) {
			audio.stopSound("sound", "game.mp3");
			audio.playSound("sound", "end.mp3");
		}
		else if (!isSoundOn) {
			audio.stopSound("sound", "game.mp3");
			audio.stopSound("sound", "end.mp3");
		}
	}
//	private void playRandomSound() {
//		AudioPlayer audio = AudioPlayer.getInstance();
//		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
//	}
}
