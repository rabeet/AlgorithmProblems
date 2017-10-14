package MustDoQuestions.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueensProblem {

	public static void main(String[] args) {
		// Place queens in an nxn table such that no two queens can attack each other
		
		List<List<String>> l = solveNQueens(8);
		for (List i : l)
			System.out.println(i);
	}
	
//	@Test
//	public void nQueensRunner() {
//		List<List<String>> ans = solveNQueens(8);
//		for (List l : ans)
//			System.out.println(l);
//	}
	
	/*
	 * solving it for the simplest case which is n = 4
	 * 
	 *  Only 2 solutions exist:
	 *  
	 [".Q..",  // Solution 1
	  "...Q",
	  "Q...",
	  "..Q."],
	
	 ["..Q.",  // Solution 2
	  "Q...",
	  "...Q",
	  ".Q.."]
	]
	
	 * Optimal sol involves some form of backtracking:
	 * 	if (queen has been placed at last row)	
	 * 		add the string to the list and return
	 * 	if (no valid pos can be found) go to last row and 	
	 * 	place a queen at a valid pos
	 * 	recursively call on the next line
	 */
	static List<List<String>> finalAns = new ArrayList();
	static int count = 0;
	public static List<List<String>> solveNQueens(int n) {
		
		int startfrom = 0;
		Set<Integer> set = new HashSet();
		for (int i = 0; i < n; i++) {
			List<List<String>> ans = getEmptyList(n);
			solveNQueens(ans, n, 0, startfrom);
			startfrom = ans.get(0).indexOf("Q");
			if (startfrom != -1 && set.add(startfrom)) {
				System.out.println("SOLVED " + ++count + " TIME(S)");
				finalAns.addAll(new ArrayList(ans));
			}
			startfrom++;
		}
		
		return finalAns;
	}
	
	
	private static void solveNQueens(List<List<String>> ans, int n, int row, int startfrom) {
		if (row >= n || row < 0) {
			return;
		}
		int pos = getValidPos(ans, row, startfrom);
		if (pos == -1) {solveNQueens(ans, n, row-1, 0); return;}// backtrack
		else ans.get(row).set(pos, "Q");
//			for (List l : ans)
//				System.out.println(l);
//			System.out.println();
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		solveNQueens(ans, n, row+1, 0);
	}

	private static int getValidPos(List<List<String>> ans, int row, int starting) {
		// see if it is a valid pos
		int pos = -1;
		int len = ans.size();
		if (ans.get(row).contains("Q")) { // already contains a queen
			int ind = ans.get(row).indexOf("Q");
			ans.get(row).set(ind, ".");
			pos = getValidPos(ans, row, ind+1);
		} else {
			for (int i = starting; i < ans.get(row).size(); i++) {
				// check just verticals for now LOL
				boolean correct = validateCell(ans, row, i);
				if (correct) {pos = i; break;}
			}
		}
			
		return pos;
	}

	private static boolean validateCell(List<List<String>> ans, int row, int i) {
		// check verticals
		boolean horizs = checkHorizontals(ans, row, i);
		
		// check diagonals
		boolean diags = checkDiagonals(ans, row, i);
		
		return horizs && diags;
	}

	private static boolean checkHorizontals(List<List<String>> ans, int row, int i) {
		int top = row, bot = row;
		while (top >= 0 && bot < ans.size()) {
			if (ans.get(top).get(i) == "Q") return false;
			if (ans.get(bot).get(i) == "Q") return false;
			top--;
			bot++;
		}
		
		while (top >= 0 ) {
			if (ans.get(top).get(i) == "Q") return false;
			top--;
		}
		
		while (bot < ans.size()) {
			if (ans.get(bot).get(i) == "Q") return false;
			bot++;
		}
		return true;
	}

	private static boolean checkDiagonals(List<List<String>> ans, int row, int i) {
		int hor = i, vert = row;
		
		while (hor >= 0 && vert >= 0){
			if (ans.get(vert).get(hor) == "Q") return false;
			hor--;
			vert--;
		}
		
		hor = i; vert = row;
		while (hor >= 0 && vert < ans.size()) {
			if (ans.get(vert).get(hor) == "Q") return false;
			hor--;
			vert++;
		}
		
		hor = i; vert = row;
		while (hor < ans.size() && vert >= 0) {
			if (ans.get(vert).get(hor) == "Q") return false;
			hor++;
			vert--;
		}
		
		hor = i; vert = row;
		while (hor < ans.size() && vert < ans.size()) {
			if (ans.get(vert).get(hor) == "Q") return false;
			hor++;
			vert++;
		}
		
		return true;
	}
	
	private static List<List<String>> getEmptyList(int n) {
		List<List<String>> ans = new ArrayList(); // init to all '.'
		String t[] = new String[n];
		for (int i = 0; i < t.length; i++) {
			t[i] = ".";
		}
		for (int i = 0; i < t.length; i++) {
			ans.add(new ArrayList(Arrays.asList(t)));
		}
		return ans;
	}
}
