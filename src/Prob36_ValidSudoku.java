import java.util.HashSet;
import java.util.Set;

public class Prob36_ValidSudoku {
	
	public static void main(String[] args) {
		
	}
	
	/*
	 * Prob 36 - Valid sudoku
Determine if a sudoku is valid.

Looks like a set problem.

for each row call isValidRow

for each column call isValidColumn

for each box call isValidBox

function isValidRow:
	add element to a set
		if already exists return false
		else return true
function isValidColumn:
	add element to a set
		if already exists return false
		else return true
function isValidBox:
	add element to a set
		if already exists return false
		else return true
	 */
	
	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (!isValidRow(board,i) || !isValidColumn(board,i)) return false;
		}
		for (int i = 0; i < board.length; i=i+3) {
			for (int j = 0; j < board.length; j=j+3) {
				if (!isValidBox(board,i,j)) return false;
			}
		}
		return true;
	}
	
	public static boolean isValidRow(char[][] board, int index) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < board.length; i++) {
			char c = board[index][i];
			if (c == '.') continue;
			if (!set.add(c)) return false;
		}
		return true;
	}
	
	public static boolean isValidColumn(char[][] board, int index) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < board.length; i++) {
			char c = board[i][index];
			if (c == '.') continue;
			if (!set.add(c)) return false;
		}
		return true;
	}
	
	public static boolean isValidBox(char[][]board, int row, int col) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				char c = board[row+i][col+j];
				if (c == '.') continue;
				if (!set.add(c)) return false;
			}
		}
		return true;
	}

}
