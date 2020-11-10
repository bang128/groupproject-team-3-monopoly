package starter;
import java.util.*;

public class Character{
	private CharacterType type;
	private Space position;
	private int row;
	private int col;
	private int money;
	private boolean move;
	private int same;
	
	public Character( CharacterType type, int row, int col, int money, boolean move, int same){
		this.setType(type);
		this.setRow(row);
		this.setCol(col);
		this.setMoney(money);
		this.setMove(move);
		this.setSame(same);
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

	@Override
	public String toString() {
		return "Character [type=" + type + ", position=" + position + ", row=" + row + ", col=" + col + ", money="
				+ money + ", move=" + move + "]";
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
		Character c = new Character(CharacterType.PLAYER1, 0, 0, 100, true, 0);
		c.ifIWereToMove(5, 0);
		System.out.print(c.ifIWereToMove(5, 0));
	}

	public int getSame() {
		return same;
	}

	public void setSame(int same) {
		this.same = same;
	}
}