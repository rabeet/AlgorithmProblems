package LeetCode;

public class ShortestPathToGetFood {

	public static void main(String[] args) {
		char[][] arr = {
				{'X','X','X','X'},
				{'X','O','*','X'},
				{'X','X','X','X'},
				{'X','#','X','X'}
				};
		
		char[][] arr2 = {
				{'*','O','X','X'},
				{'X','O','O','O'},
				{'X','O','X','X'},
				{'O','O','O','#'}
				};
		
		char[][] arr3 = {
				{'*','O','O','O'},
				{'X','X','X','O'},
				{'X','#','O','O'},
				{'X','X','X','O'},
				{'O','O','O','O'}
				};
		System.out.println(shortestPath(arr));
		System.out.println(shortestPath(arr2));
		System.out.println(shortestPath(arr3));
	}
	
	/*
	 * TESTING:
	 * XXXX
	 * XO*X
	 * XOXX
	 * X#XX
	 * 
	 */
	public static int shortestPath(char[][] arr) {
		// find ben
		int row=0, col=0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == '*') {
					row = i;
					col = j;
					break;
				}
			}
		}
		
		// look for food recursively
		int steps = look(arr, row, col, 0);
		if (steps == Integer.MAX_VALUE) steps = -1;
		
		return steps;
	}

	private static int look(char[][] arr, int row, int col, int i) {
		if (row >= arr.length || row < 0 || col < 0 || col >= arr[0].length || arr[row][col] == 'X')
			return Integer.MAX_VALUE;
		else if (arr[row][col] == '#')
			return i;
		else {
			arr[row][col] = 'X';
			return Math.min(look(arr, row+1, col,i+1), Math.min(look(arr, row, col+1, i+1), Math.min(look(arr,row-1,col,i+1), look(arr, row, col-1,i+1))));
		}
	}

}
