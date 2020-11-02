package starter;
import java.util.*;
public class Space {
	
	private int r;
	private int c;
	
	public Space(int row, int col) {
		r = row;
		c = col;
	}
	public void setRow(int row) {
		this.r = row;
	}
	public void setCol(int col) {
		this.c = col;
	}
	
	public int getRow() {
		return r;
	}
	
	public int getCol() {
		return c;
	}

	public String toString() {
		return "Space [r=" + r + ", c=" + c + "]";
	}
}


