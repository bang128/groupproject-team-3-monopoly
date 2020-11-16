package starter;
import java.util.*;

public class Level {
	private Items[][] board;
	public ArrayList<Character> characters;
	private int bank, nRows, nCols;
	private Character turn;
	
	public Level(int nR, int nC) {
		nRows = nR;
		nCols = nC;
		board = new Items[nR][nC];
		bank = 5000;
		characters = new ArrayList<Character>();
		setUp();
		ChooseFirstTurn();
	}
	public void ChooseFirstTurn() {
		Random generator = new Random();
		int r = generator.nextInt();
		if (r % 2 == 0) turn = characters.get(0);
		else turn = characters.get(1);
	}
	public void setUp() {
		for (int r = 1; r < nRows - 1; r++) {
			board[r][0] = new Building();
			board[r][nCols - 1] = new Building();	
		}
		
		for (int c = 1; c < nCols - 1; c++) {
			board[0][c] = new Building();
			board[nRows - 1][c] = new Building();
			
		}
		
		board[0][0] = new Items();
		board[0][nCols - 1] = new goToJail();
		board[nRows - 1][0] = new Jail();
		board[nRows - 1][nCols - 1] = new Items();
		
		int row, col;
		Random generator = new Random();
		for (int i = 0; i < 1; i++) {
			row = generator.nextInt(nRows - 2) + 1;
			board[row][0] = new Chance();
			row = generator.nextInt(nRows - 2) + 1;
			board[row][nCols - 1] = new Chance();
			col = generator.nextInt(nCols - 2) + 1;
			board[0][col] = new Chance();
			col = generator.nextInt(nCols - 2) + 1;
			board[nRows - 1][col] = new Chance();
		}
		
		for (int i = 0; i < 1; i++) {
			row = generator.nextInt(nRows - 2) + 1;
			board[row][0] = new CommunityChest();
			row = generator.nextInt(nRows - 2) + 1;
			board[row][nCols - 1] = new CommunityChest();
			col = generator.nextInt(nCols - 2) + 1;
			board[0][col] = new CommunityChest();
			col = generator.nextInt(nCols - 2) + 1;
			board[nRows - 1][col] = new CommunityChest();
		}
		
		for (int i = 0; i < 1; i++) {
			row = generator.nextInt(nRows - 2) + 1;
			board[row][0] = new Tax();
			row = generator.nextInt(nRows - 2) + 1;
			board[row][nCols - 1] = new Tax();
			col = generator.nextInt(nCols - 2) + 1;
			board[0][col] = new Tax();
			col = generator.nextInt(nCols - 2) + 1;
			board[nRows - 1][col] = new Tax();
		}
		
		characters.add(new Character(CharacterType.PLAYER1, nRows -1, nCols - 1, 2000, true, 0));
		characters.add(new Character(CharacterType.PLAYER2, nRows -1, nCols - 1, 2000, true, 0));
		
	}
	
	public Items getBoardAt(int r, int c) {return board[r][c];}
	
	public void moveNumSpaces(int numSpaces) {
		if(getTurn().isMove()) {
			Space pre = null;
			if (turn.getRow() == nRows - 1 && turn.getCol() == nCols - 1) {
				pre = turn.ifIWereToMove(0, (-1)*numSpaces);
			}
			else if (turn.getRow() == nRows - 1 && turn.getCol() == 0) {
				pre = turn.ifIWereToMove((-1)*numSpaces, 0);
			}
			else if (turn.getRow() == 0 && turn.getCol() == 0) {
				pre = turn.ifIWereToMove(0, numSpaces);
			}
			else if (turn.getRow() == 0 && turn.getCol() == nCols - 1) {
				pre = turn.ifIWereToMove(numSpaces, 0);
			}
			else if (turn.getRow() == nRows - 1) {
				pre = turn.ifIWereToMove(0, (-1)*numSpaces);
			}
			else if (turn.getCol() == 0) {
				pre = turn.ifIWereToMove((-1)*numSpaces, 0);
			}
			else if (turn.getRow() == 0) {
				pre = turn.ifIWereToMove(0, numSpaces);
			}
			else if (turn.getCol() == nCols - 1) {
				pre = turn.ifIWereToMove(numSpaces, 0);
			}
			
			
			int numMove;
			if(pre.getRow() == nRows - 1) {
				if(pre.getCol() < 0) {
					numMove = turn.getCol();
					turn.move(0, (-1)*numMove);
					moveNumSpaces(numSpaces - numMove);
				}
				else turn.move(0, (-1)*numSpaces);
			}
			else if(pre.getCol() == 0) {
				if (pre.getRow() < 0) {
					numMove = turn.getRow();
					turn.move((-1)*numMove,0);
					moveNumSpaces(numSpaces - numMove);
				}
				else turn.move((-1)*numSpaces,0);
			}
			else if (pre.getRow() == 0) {
				if(pre.getCol() > nCols - 1) {
					numMove = nCols - turn.getCol() - 1;
					turn.move(0, numMove);
					moveNumSpaces(numSpaces - numMove);
				}
				else turn.move(0, numSpaces);
			}
			else if (pre.getCol() == nCols - 1) {
				if(pre.getRow() > nRows - 1) {
					numMove = nRows - turn.getRow() - 1;
					turn.move(numMove, 0);
					moveNumSpaces(numSpaces - numMove);
				}
				else turn.move(numSpaces, 0);
			}
		}
	}
	public Items[][] getBoard() {
		return board;
	}
	public void setBoard(Items[][] board) {
		this.board = board;
	}
	
	public int getBank() {
		return bank;
	}
	public void setBank(int bank) {
		this.bank = bank;
	}
	
	public int getnRows() {
		return nRows;
	}
	public void setnRows(int nRows) {
		this.nRows = nRows;
	}
	
	public int getnCols() {
		return nCols;
	}
	public void setnCols(int nCols) {
		this.nCols = nCols;
	}
	
	public Character getTurn() {
		return turn;
	}
	
	public void changeTurn() {
		if (turn == characters.get(0)) turn = characters.get(1);
		else turn = characters.get(0);
	}
	public boolean sendToJail() {
		if ((getBoardAt(turn.getRow(), turn.getCol()).getName() == "goToJail" && !turn.isMove()) || turn.getSame() == 3) {
			turn.setRow(nRows -1);
			turn.setCol(0);
			turn.setPosition(new Space(turn.getRow(), turn.getCol()));
			turn.setMove(false);
			return true;
		}
		return false;
	}
	
	public boolean checkEnd() {
		for(Character c: characters) {
			if (c.getMoney() < 0)
				return true;
		}
		if(getBank() < 0) return true;
		return false;
	}
	
	public void resetGame() {
		for (Character c: characters) {
			characters.remove(c);
		}
		setUp();
		ChooseFirstTurn();
	}
	public static void main(String[] args)  {
		Level l = new Level(11,11);
		System.out.println(l.getTurn().getPosition());
		//System.out.print(l.getTurn().ifIWereToMove(0, -15) + "\n");
		l.moveNumSpaces(15);
		System.out.println("Move 15:" + l.getTurn().getPosition());
		
		l.moveNumSpaces(10);
		System.out.println("Move 10: " + l.getTurn().getPosition());
		
		l.moveNumSpaces(7);
		System.out.println("Move 7: " + l.getTurn().getPosition());
		
		l.moveNumSpaces(9);
		System.out.print("Move 9: " + l.getTurn().getPosition());
	}

}
