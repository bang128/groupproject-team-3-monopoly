package starter;
import java.util.*;

public class Character{
	private CharacterType type;
	private Space position;
	private Space start;
	private int row;
	private int col;
	private int money;
	private boolean move;
	
	public Character( CharacterType type, int row, int col, int money, boolean move){
		this.setType(type);
		this.setRow(row);
		this.setCol(col);
		this.setMoney(money);
		this.setMove(move);
	}

	public CharacterType getType() {
		return type;
	}

	public void setType(CharacterType type) {
		this.type = type;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money += money;
	}

	public boolean isMove() {
		return move;
	}

	public void setMove(boolean move) {
		this.move = move;
	}
	
	public Space getStart() {
		return start;
	}

	public void setStart(Space start) {
		this.start = start;
	}

	public Space getPosition() {
		return position;
	}

	public void setPosition(Space position) {
		this.position = position;
	}

	public String toString() {
		String s;
		s="CharacterType: "+type.toString();
		return s;
		}
	
	public Space ifIWereToMove(int numSpaces) {
		Space pre = getPosition();
		if (move == true) {
			pre.setRow(getPosition().getRow() + numSpaces);
			return pre;
		}
		pre.setCol(getPosition().getCol() + numSpaces);
		return pre;
	}
	
	public void move(int numSpaces) {
		if(move==false) {
			getPosition().setRow(getPosition().getRow()+numSpaces);
		}
		else {
			getPosition().setCol(getPosition().getCol()+numSpaces);
		}
	}
	
	
}