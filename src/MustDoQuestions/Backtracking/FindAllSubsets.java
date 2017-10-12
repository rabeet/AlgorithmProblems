package MustDoQuestions.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class FindAllSubsets {

	public static void main(String[] args) {
		// find all possible subsets
		System.out.println(subsets(new int[]{1,2,3}));
	}
	
	/*
	 * 1,2,3
	 */
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ans = new ArrayList();
		buildSet(nums, ans, new ArrayList(), 0);
		return ans;
	}
	
	private static void buildSet(int[] given, List<List<Integer>> ans, List<Integer> temp, int start) {
		if (temp.size() == given.length) {
			ans.add(new ArrayList(temp));
			return;
		}
		ans.add(new ArrayList(temp));
		for (int i = start; i < given.length; i++) {
			if (temp.contains(given[i])) continue;
			temp.add(given[i]);
			buildSet(given, ans, temp, i+1);
			temp.remove(temp.size()-1); //backtrack
		}
	}

}
