package CtCi_v4;

public class Prob8_2 {

	/*
	 * 8.2: Find the number of possible paths for robot to get to the bottom
	 * right from top left of a NxN grid.
	 * 
	 * DP way is possible for this problem however i am going to answer this
	 * using the simple way FOLLOW UP: Imagine certain squares are �off limits�,
	 * such that the robot can not step on them. Design an algorithm to get all
	 * possible paths for the robot.
	 * 
	 */
	static private int paths = 0;
	static private final int OBSTACLE = 1;

	public static void main(String[] args) {
		int[][] grid = new int[3][4];
		grid[1][1] = OBSTACLE;
		System.out.println(possiblePathsForRobot(grid)); // NOT WORKING
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

	public static int possiblePathsForRobot(int[][] grid) {
		populatePaths(grid, 0, 0);
		int ans = paths;
		paths = 0;
		return ans;
	}

	public static void populatePaths(int[][] grid, int r, int c) {
		if (r >= grid.length || c >= grid[0].length)
			return;
		if (grid[r][c] == OBSTACLE)
			return;
		if (r == grid.length - 1 && c == grid.length - 1) {
			paths++;
			return;
		}
		populatePaths(grid, r + 1, c);
		populatePaths(grid, r, c + 1);
	}
}
