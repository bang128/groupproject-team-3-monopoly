package starter;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import acm.graphics.GImage;
import acm.graphics.GLabel;
import acm.graphics.GObject;

public class SettingPane extends GraphicsPane{
	//public static ArrayList<Integer> players;
	
	private MainApplication program;
	private GLabel label;
	private GLabel prompt;
	private final String label_font = "Comic Sans MS-Bold-35";
	private final String prompt_font = "Comic Sans MS-Bold-24";
	private int player_num=0;
	private ArrayList<GImage> ops = new ArrayList<GImage>();
	
	
	public SettingPane(MainApplication app) {
		super();
		program = app;
		label = new GLabel("Setting", MainApplication.WINDOW_WIDTH/2 - 90, 90);
		label.setFont(label_font);
		label.setColor(new Color(153, 0, 51));
		prompt = new GLabel ("Player 1, please choose an icon.", 20, 200);
		prompt.setFont(prompt_font);
		prompt.setColor(new Color(153, 0, 51));
		//players = new ArrayList<Integer>();
		SetOptions();
	}
	private void SetOptions() {
		ops.clear();
		
		for (int i=0; i<5; i++) {
			ops.add(new GImage("icon_ops/op" + (i+1)+ GraphicsGame.IMG_EXTENSION, 125*i + 20, 250));
			ops.get(i).setSize(70, 70);
		}
	}
	private void resetSetting() {
		ops.clear();
		player_num = 0;
		SetOptions();
		prompt.setLabel("Player 1, please choose an icon");
	}
	@Override
	public void showContents() {
		// TODO Auto-generated method stub
		program.add(label);
		program.add(prompt);
		for (int i=0; i<ops.size(); i++) {
			program.add(ops.get(i));
		}
		
	}

	@Override
	public void hideContents() {
		// TODO Auto-generated method stub
		program.remove(label);
		program.remove(prompt);
		for (int i=0; i<ops.size(); i++) {
			program.remove(ops.get(i));
		}
		resetSetting();
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		GObject obj = program.getElementAt(e.getX(), e.getY());
		for (int i=0; i<ops.size(); i++) {
			if (obj == ops.get(i)) {
				GraphicsGame.player_name[player_num] = "icon_ops/op" + (i+1);
				program.remove(ops.get(i));
				player_num++;
			}
		}
		if (player_num == 1) {
			prompt.setLabel("Player 2, please choose an icon");
			program.add(prompt);
		}
		else if (player_num == 2) {
			program.switchToMenu();
		}
		else System.out.print("error");
	}

}
