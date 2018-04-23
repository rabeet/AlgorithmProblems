package CtCi_v4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Prob1_7 {
	
	/*
	 * 1.7: Write algo such that if an element in an MxN matrix is 0 its entire row and col is set to 0
	 * 
	 * Do I have to search or am i the element which is 0?
	 * Assuming the indices of the 0 element is given to us.
	 * 
	 * Ignore the row and col that was zeroed out.
	 * Space complexity of O(mn) will yield a bad solution
	 * Space complexity if O(m + n) (row+col to ignore) is an improvement but can be done better
	 * Constant space complexity can use 2 32bit ints?
	 * 1 for rows and 1 for col but the sol is only limited to 32 rows and cols.
	 */

	public static void main(String[] args) {
		int[][] arr = {{3,5,5,6,9,1,4,5,0,5},{2,7,9,5,9,5,4,9,6,8},{6,0,7,8,1,0,1,6,8,1},{7,2,6,5,8,5,6,5,0,6},{2,3,3,1,0,4,6,5,3,5},{5,9,7,3,8,8,5,1,4,3},{2,4,7,9,9,8,4,7,3,7},{3,5,2,8,8,2,2,4,9,8}};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		setZeroes(arr);
		System.out.println();
		for (int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}
	
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
	
	public static void zeroOut(int[][] matrix, int row, int col) {
		int i = row;
		int j = row;
		
		// clear rows
		while (i >= 0 || j < matrix.length) {
			if (i >= 0)
				matrix[i][col] = 0;
			if (j < matrix.length)
				matrix[j][col] = 0;
			i--;
			j++;
		}
		
		// clear columns
		i = col; 
		j = col;
		while (i >= 0 || j < matrix[row].length) {
			if (i >= 0)
				matrix[row][i] = 0;
			if (j < matrix[row].length)
				matrix[row][j] = 0;
			i--;
			j++;
		}
	}
}
