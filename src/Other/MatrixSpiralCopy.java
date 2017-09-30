package Other;
import java.io.*;
import java.util.*;

class MatrixSpiralCopy {

  static int track = 0;
  static int[] spiralCopy(int[][] inputMatrix) {
    if (inputMatrix == null) return null;
    if (inputMatrix.length < 1) return null;
    int[] ans = new int[inputMatrix.length*inputMatrix[0].length];
    boolean[][] printed = new boolean[inputMatrix.length][inputMatrix[0].length];
    spiralCopy(inputMatrix, ans, printed, 0, 0, true, true);
    return ans;
  }

  // recursive method to populate the array
  static void spiralCopy(int[][] inputMatrix, int[] ans, boolean[][] printed, int r, int c, boolean row, boolean col) {
    if (inputMatrix == null || printed[r][c] == true) return;
    if (row && col) {
      int c_n = populateRow(inputMatrix, printed, ans, r, c, row);
      spiralCopy(inputMatrix, ans, printed, r, c_n, !row, col);
    }
    else if (!row && col) {
      int r_n = populateCol(inputMatrix, printed, ans, r, c, col);
      spiralCopy(inputMatrix, ans, printed, r_n, c, row, !col);
    }
    else if (row && !col) {
      int c_n = populateRow(inputMatrix, printed, ans, r, c, !row);
      spiralCopy(inputMatrix, ans, printed, r, c_n, !row, !col);
    }
    else {
      col = false;
      int r_n = populateCol(inputMatrix, printed, ans, r, c, col);
      col = true;
      spiralCopy(inputMatrix, ans, printed, r_n, c, row, col);      
    }
  }
  
  static int populateRow(int[][] inputMatrix, boolean[][] printed, int[] ans, int row, int col, boolean row_b) {
    if (row_b) {
      for (; col < inputMatrix[row].length; col++) {
        if (printed[row][col] == true) return col;
        printed[row][col] = true;
        ans[track++] = inputMatrix[row][col];
      }
    } else {
      for (; col >= 0; col--) {
        if (printed[row][col] == true) return col;
        printed[row][col] = true;
        ans[track++] = inputMatrix[row][col];
      }
    }
    return col-1;
  }
  
  static int populateCol(int[][] inputMatrix, boolean[][] printed, int[] ans, int row, int col, boolean col_b) {
    if (col_b) {
      for (; row < inputMatrix.length; row++) {
        if (printed[row][col] == true) return row;
        printed[row][col] = true;
        ans[track++] = inputMatrix[row][col];
      }
    } else {
      for (; row >= 0; row--) {
        if (printed[row][col] == true) return row;
        printed[row][col] = true;
        ans[track++] = inputMatrix[row][col];
      }
    }
    return row-1;
  }
  
  public static void main(String[] args) {
	  int[][] t= new int[3][3];
	  t[0][0] = 1; t[1][0]=2; t[2][0] = 3;
	  System.out.println(Arrays.toString(spiralCopy(t)));
  }

}