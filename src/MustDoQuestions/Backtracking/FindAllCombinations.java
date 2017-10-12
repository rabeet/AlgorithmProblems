package MustDoQuestions.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllCombinations {

	public static void main(String[] args) {
		// find all combinations of a given array / arraylist
		// n^n possible combinations
		System.out.println(combinations(new int[]{1,2,3}));
	}
	
	public static List<List<Integer>> combinations(int[] nums) {
		List<List<Integer>> ans = new ArrayList();
		buildList(nums, ans, new ArrayList());
		return ans;
	}
	
	private static void buildList(int[] given, List<List<Integer>> ans, List<Integer> temp) {
		if (temp.size() == given.length) {
			ans.add(new ArrayList(temp));
			return;
		}
		for (int i = 0; i < given.length; i++) {
			temp.add(given[i]); // not skipping duplication since its combinations not permutations
			buildList(given, ans, temp);
			temp.remove(temp.size()-1); // backtrack by removing last element
		}
	}

}
