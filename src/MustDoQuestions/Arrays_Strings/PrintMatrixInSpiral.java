package MustDoQuestions.Arrays_Strings;

public class PrintMatrixInSpiral {

	public static void main(String[] args) {
		// Print a matrix in a spiral manner:
		int[][] matrix = {{1,2,3},
						  {4,5,6},
						  {7,8,9}};
		
		int[][] matrix2 = {{1,2,3}};
		printSpiral(matrix);
		System.out.println();
		printSpiral(matrix2);
	}
	
	public static void printSpiral(int[][] matrix) {
		// 4 vars -> rowstart, rowend, colstart, colend
		
		/*
		 * int rows,rowe,cols,cole; all starts init to 0 and ends init to end of col and row
		 * for i = 0 -> matrix.row * matrix.col
		 * 	for j = cols to colend
		 * 		print matrix[rows][j];
		 * 	rows++;
		 * 	for j = rows to rowe
		 * 		print matrix[j][cole]
		 * 	cole--;
		 * 	for j = cole to cols
		 * 		print matrix[rowe][j]
		 * 	rowe--;
		 * 	for j = rowe to rows
		 * 		print matrix[j][cols]
		 * 	cols++;
		 */
		int rows = 0, rowe=matrix.length-1, cols = 0, cole = matrix[0].length-1;
		for (int i = 0; i < matrix.length*matrix[0].length;) {
			for (int j = cols; j <= cole; j++,i++)
				System.out.println(matrix[rows][j]);
			rows++;
			for (int j = rows; j <= rowe; j++,i++)
				System.out.println(matrix[j][cole]);
			cole--;
			if (rows <= rowe) {
				for (int j = cole; j >= cols; j--,i++)
					System.out.println(matrix[rowe][j]);
				rowe--;
			}
			if (cols <= cole) {
				for (int j = rowe; j >= rows; j--,i++)
					System.out.println(matrix[j][cols]);
				cols++;
			}
		}
	}

}
