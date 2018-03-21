package Other.CommerceHub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountingGroups {

	public static void main(String[] args) {
		int[][] inp = { 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0 },
				{ 1, 1, 1, 0, 0, 0, 0, 1, 1, 1 }, 
				{ 1, 1, 0, 0, 1, 0, 0, 1, 1, 1 }, 
				{ 1, 0, 1, 0, 0, 1, 1, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		int[] t = { 1, 10, 20, 2, 6 };
		System.out.println(Arrays.toString(countGroups(inp, t)));

		int[][] inp2 = { 
				{ 1, 0, 1, 1, 0 }, 
				{ 0, 1, 0, 0, 1 }, 
				{ 1, 0, 1, 1, 0 }, 
				{ 1, 0, 1, 1, 0 },
				{ 0, 1, 0, 0, 1 } };
		int[] t2 = { 1, 2, 3, 4, 5 };
		System.out.println(Arrays.toString(countGroups(inp2, t2)));
	}

	/*
	 * Complete the function below.
	 */
	static int[] countGroups(int[][] m, int[] t) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if (m[i][j] == 0)
					continue;
				int found = findOnes(m, i, j);
				map.put(found, map.getOrDefault(found, 0) + 1);
			}
		}
		int[] ans = new int[t.length];
		for (int i = 0; i < t.length; i++) {
			ans[i] = map.getOrDefault(t[i], 0);
		}
		return ans;
	}

	private static int findOnes(int[][] m, int row, int col) {
		if (row >= m.length || col >= m[0].length || row < 0 || col < 0)
			return 0;
		if (m[row][col] == 0)
			return 0;
		m[row][col] = 0;
		return 1 + findOnes(m, row + 1, col) + findOnes(m, row, col + 1) + findOnes(m, row - 1, col) + findOnes(m, row, col -1);
	}

}
