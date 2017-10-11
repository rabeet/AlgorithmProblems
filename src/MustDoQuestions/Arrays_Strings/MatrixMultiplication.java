package MustDoQuestions.Arrays_Strings;

import java.util.Arrays;

public class MatrixMultiplication {
	
	public static void main(String[] args) {
		int[][] A =  {{1,2,4},{2,5,1}};
		int[][] B =  {{8,9},{0,5},{5,1}};
		int[][] A1 = {{1,0,0},{-1,0,3}};
		int[][] B1 = {{7,0,0},{0,0,0},{0,0,1}};
		System.out.println(Arrays.deepToString(multiply(A,B)));
		System.out.println(Arrays.deepToString(multiply(A1,B1)));
	}
	
	public static int[][] multiply (int[][] A, int[][] B) {
		// dot product of two matrices -> columns in A = rows in b
		
		/*
		 * 1 2 4  X   8 9
		 * 2 5 1  X   0 5
		 * 			  1 1
		 * 
		 * 9 18 36
		 * 31 75 15
		 * 
		 * initialize ans = [num_of_rows_in_A][num_of_cols_in_B]
		 * 
		 * for each row in ans: i
		 * 	for each col in ans[i]: j
		 * 		ans[i][j] = dot prod of ith row in A and jth col in B
		 * return ans;	
		 * TC: O(n^3)
		 */
		int[][] ans = new int[A.length][B[0].length];
		
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[i].length; j++) {
				ans[i][j] = dotProduct(A, B, i, j);
			}
		}
		
		return ans;
	}
	
	private static int dotProduct(int[][] A, int[][] B, int row, int col) {
		int ans = 0;
		for (int i = 0; i < A[row].length; i++) {
			ans += A[row][i]*B[i][col];
		}
		return ans;
	}
	
	private static int getProdRow(int[][] matrix, int num, int row) {
		int ans = 0;
		for (int i = 0 ; i < matrix[row].length; i++) {
			ans += num*matrix[row][i];
		}
		return ans;
	}
	
	private static int getProdCol(int[][] matrix, int num, int col) {
		int ans = 0;
		for (int i = 0 ; i < matrix.length; i++) {
			ans += num*matrix[i][col];
		}
		return ans;
	}

}
