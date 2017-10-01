package LeetCode;

// DP solution - keep track of ways to get to a cell by adding the top and left cell values
// ans is the m-1th row and n-1th col after populating
public class Prob62_UniquePaths {
	public int uniquePaths(int m, int n) {
		if (m == 1 && n == 1)
			return 1;
		if (m < 1 || n < 1)
			return 0;

		int[][] cache = new int[m][n];

		// populate the 1s
		for (int i = 0, j = 0; i < m || j < n; i++, j++) {
			if (i < m)
				cache[i][0] = 1;
			if (j < n)
				cache[0][j] = 1;
		}

		// populate the rest of the cache
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				cache[i][j] = cache[i - 1][j] + cache[i][j - 1];
			}
		}
		return cache[m - 1][n - 1];
	}

	static int numPaths = 0;

	public void populateNums(int c_r, int c_c, int r, int c) {
		if (c_r > r || c_c > c)
			return;
		if (c_r == r && c_c == c) {
			numPaths++;
			return;
		}
		populateNums(c_r + 1, c_c, r, c);
		populateNums(c_r, c_c + 1, r, c);
	}

	public long fac(int x) {
		long output = 1;
		for (int i = 1; i <= x; i++) {
			output = output * i;
		}
		return output;
	}

}
