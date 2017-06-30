
public class Prob419_BattleShips {

	public static void main(String[] args) {
		
	}
	
	/*
	X..X
	...X
	...X
	*/
	
	
	// only count the battleships to the top-left. Meaning they have not been counted before
	public static int countBattleshipsSmart(char[][] board) {
		int battleships = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j <board[0].length; j++) {
				if (board[i][j] == 'X') {
					if (i != 0 && j != 0) {
						if (board[i-1][j] != 'X' && board[i][j-1] != 'X') battleships++;
					}
					else if (i != 0 && j == 0) {
						if (board[i-1][j] != 'X') battleships++;
					}
					else if (i == 0 && j != 0) {
						if (board[i][j-1] != 'X') battleships++;
					}
					else {
						battleships++;
					}
				}
			}
		}
		
		return battleships;
	}
	
	public static int countBattleships(char[][] board) {
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		int battleships = 0;
		for (int i  = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				
				// Encounter a battleship and it has not been encountered before
				if (board[i][j] == 'X' && !visited[i][j]) {
					// visit it
					visit(board, visited, i, j);
					// increase ship count
					battleships++;
				}
				else continue;
					
			}
		}
		
		return battleships;
	}
	
	public static void visit(char[][] board, boolean[][] visited, int x, int y) {
		if (x == board.length || y == board[0].length || board[x][y] == '.')
			return;
		visited[x][y] = true;
		visit(board, visited, x+1, y);
		visit(board, visited, x, y+1);
	}
}

/*
X..X
...X
...X
*/

/*
XXX.X.X
....X.X
XXXX...
*/