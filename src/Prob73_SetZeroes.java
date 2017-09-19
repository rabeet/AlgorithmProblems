import java.util.ArrayList;
import java.util.List;

public class Prob73_SetZeroes {
	
public static void setZeroes(int[][] matrix) {
		
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		
		// first pass to see what rows and cols need to be 0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for (int i : rows) {
			zeroOutRow(matrix, i);
		}
		
		for (int i : cols) {
			zeroOutCol(matrix, i);
		}
		
//		for (int i = 0; i < matrix.length; i++) {
//			System.out.println(Arrays.toString(matrix[i]));
//		}
	}
	
	public static void zeroOutRow(int[][] matrix, int row) {
		
		// clear out passed row
		for (int i = 0; i < matrix[row].length; i++) {
			matrix[row][i] = 0;
		}
	}
	
public static void zeroOutCol(int[][] matrix, int col) {
		
		// clear out passed col
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}

}
