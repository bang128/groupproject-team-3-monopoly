package starter;
public class MainApplication extends GraphicsApplication {
	public static final int WINDOW_WIDTH = 700;
	public static final int WINDOW_HEIGHT = 900;
	public static final String MUSIC_FOLDER = "sounds";
	private static final String[] SOUND_FILES = { "r2d2.mp3", "somethinlikethis.mp3" };

	private SomePane somePane;
	private MenuPane menu;
	private GraphicsGame graphicsGame;
	private int count;

	public void init() {
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	}

	public void run() {
		System.out.println("Exit");
		somePane = new SomePane(this);
		menu = new MenuPane(this);
		graphicsGame = new GraphicsGame(this);
		switchToMenu();
	}

	public void switchToMenu() {
		//playRandomSound();
		count++;
		switchToScreen(menu);
	}

	public void switchToSome() {
		//playRandomSound();
		switchToScreen(somePane);
	}
	
	public void switchToGraphicsGame() {
		switchToScreen(graphicsGame);
	}

//	private void playRandomSound() {
//		AudioPlayer audio = AudioPlayer.getInstance();
//		audio.playSound(MUSIC_FOLDER, SOUND_FILES[count % SOUND_FILES.length]);
//	}
}
