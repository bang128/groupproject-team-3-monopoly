package starter;

import java.lang.Object;
import javax.swing.JOptionPane;

public class Items {
	protected char symbol;
	public void setSymbol(char s){
		symbol = s;
	}
	public char getSymbol() {
		return symbol;
	}
	public void visit(Character player) {}
	
	public boolean handleOption(Object[] options, String popup_name, String message) {
		int choice = JOptionPane.showOptionDialog(null, message, popup_name, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		System.exit(0);
		if (choice == JOptionPane.YES_OPTION) {  
			return true;
		}
		return false;
	}
	
}
