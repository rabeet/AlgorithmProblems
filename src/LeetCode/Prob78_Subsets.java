package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob78_Subsets {

	public static List<List<Integer>> subsets(int[] list) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> given = new ArrayList<Integer>(list.length);
		for (int i : list) {
			given.add(i);
		}
		return getSubsets(given);
	}

	public static List<List<Integer>> getSubsets(List<Integer> list) {
		List<List<Integer>> ans = new ArrayList<>();
		subsetsBacktrack(ans, new ArrayList<>(), list, 0);
		return ans;
	}

	private static void subsetsBacktrack(List<List<Integer>> ans, ArrayList<Integer> tempList, List<Integer> given,
			int start) {
		if (tempList.size() == given.size()) {
			ans.add(new ArrayList<>(tempList)); // new because we need to make
												// changes to this temp list
		} else {
			ans.add(new ArrayList<>(tempList));
			for (int i = start; i < given.size(); i++) {
				if (tempList.contains(given.get(i)))
					continue;
				tempList.add(given.get(i));
				subsetsBacktrack(ans, tempList, given, i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

}
