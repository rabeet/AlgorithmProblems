package LeetCode;

public class Prob63_UniquePaths {
	
	
	static private int paths = 0;
	static private final int OBSTACLE = 1;


	public static void main(String[] args) {

		int[][] grid = new int[3][4];
		grid[1][1] = OBSTACLE;
		System.out.println(possiblePathsForRobotDP(grid, grid.length - 1, grid[0].length - 1));
		System.out.println(possiblePathsForRobotMemoization(grid));
	
	}
	
	public static int possiblePathsForRobotDP(int[][] grid, int r, int c) {
		if (r == 0 && c == 0)
			return 1;
		if (r < 0 || c < 0)
			return 0;
		if (grid[r][c] == OBSTACLE)
			return 0;
		return possiblePathsForRobotDP(grid, r - 1, c) + possiblePathsForRobotDP(grid, r, c - 1);
	}

	
	public static int possiblePathsForRobotMemoization(int[][] grid) {
		int[][] cache = populateCache(grid);
        return cache[cache.length-1][cache[0].length-1];
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
