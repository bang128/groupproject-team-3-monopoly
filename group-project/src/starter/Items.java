package starter;

import java.lang.Object;
import javax.swing.JOptionPane;

public class Items {
	protected String name;

	
	public Items() {
		name = "";
	}
	public void setName(String n){
		name = n;
	}
	public String getName() {
		return name;
	}
	
	public boolean handleOption(Object[] options, String popup_name, String message) {
		int choice = JOptionPane.showOptionDialog(null, message, popup_name, JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (choice == JOptionPane.YES_OPTION) {  
			return true;
		}
		return false;
	}
	public void visit(Character Player) {
		// TODO Auto-generated method stub
		
	}
	
	
}
