package starter;
import java.util.*;

public class Character{
	private CharacterType type;
	private Space position;
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
		position = new Space(row, col);
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
	
	public Space ifIWereToMove(int numRows, int numCols) {
		if (move == true) {
			return new Space(row + numRows, col + numCols);
		}
		return null;
	}
	
	public void move(int numRows, int numCols) {
		if(move) {
			row = row + numRows;
			col = col + numCols;
			setPosition(new Space(row, col));
		}
	}
	public static void main(String[] args)  {
		Character c = new Character(CharacterType.PLAYER1, 0, 0, 100, true);
		c.ifIWereToMove(5, 0);
		System.out.print(c.ifIWereToMove(5, 0));
	}
}