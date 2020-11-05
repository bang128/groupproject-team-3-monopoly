package starter;
import java.util.*;

public class Level {
	private Items[][] board;
	public ArrayList<Character> characters;
	private int bank, nRows, nCols;
	
	public Level(int nR, int nC) {
		nRows = nR;
		nCols = nC;
		board = new Items[nR][nC];
		bank = 10000;
		characters = new ArrayList<Character>();
		setUp();
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
		board[0][nCols - 1] = new Items();
		board[nRows - 1][0] = new Items();
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
		
		characters.add(new Character(CharacterType.PLAYER1, nRows -1, nCols - 1, 2000, true));
		characters.add(new Character(CharacterType.PLAYER2, nRows -1, nCols - 1, 2000, true));
		
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

}
