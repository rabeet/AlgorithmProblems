package MustDoQuestions.DynamicProgramming;

import java.util.Set;
import java.util.TreeSet;

public class TopLeftToBottomRight {

	static private final int OBSTACLE = 1;

	public static void main(String[] args) {

		int[][] grid = new int[3][4];
		grid[1][1] = OBSTACLE;
		System.out.println(possiblePathsForRobotDP(grid, grid.length - 1, grid[0].length - 1));
		System.out.println(possiblePathsForRobotMemoization(grid));
		TreeSet<Integer> set = new TreeSet();

	}
	
	// O(1) space
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        //Empty case
        if(obstacleGrid.length == 0) return 0;
        
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1)
                    obstacleGrid[i][j] = 0;
                else if(i == 0 && j == 0)
                    obstacleGrid[i][j] = 1;
                else if(i == 0)
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;// For row 0, if there are no paths to left cell, then its 0,else 1
                else if(j == 0)
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;// For col 0, if there are no paths to upper cell, then its 0,else 1
                else
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        
        return obstacleGrid[rows - 1][cols - 1];
        
    }
	
	// TOP DOWN
	public static int possiblePathsForRobotDP(int[][] grid, int r, int c) {
		if (r == 0 && c == 0)
			return 1;
		if (r < 0 || c < 0)
			return 0;
		if (grid[r][c] == OBSTACLE)
			return 0;
		return possiblePathsForRobotDP(grid, r - 1, c) + possiblePathsForRobotDP(grid, r, c - 1);
	}

	// BOTTOM UP
	public static int possiblePathsForRobotMemoization(int[][] grid) {
		int[][] cache = populateCache(grid);
		return cache[cache.length - 1][cache[0].length - 1];
	}

	public static int[][] populateCache(int[][] grid) {
		int[][] cache = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i == 0 && j == 0) {
					if (grid[i][j] != 1)
						cache[i][j] = 1;
					continue;
				}
				if (grid[i][j] == 1) {
					cache[i][j] = 0;
					continue;
				}
				int r = i - 1, c = j - 1;
				cache[i][j] = c < 0 ? cache[i][j] + 0 : cache[i][j] + cache[i][c];
				cache[i][j] = r < 0 ? cache[i][j] + 0 : cache[i][j] + cache[r][j];
			}
		}
		return cache;
	}

}
