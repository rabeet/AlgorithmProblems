package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob46_Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList();
		buildList(nums, ans, new ArrayList<>());
		return ans;
	}

	static private void buildList(int[] given, List<List<Integer>> ans, List<Integer> temp) {
		if (temp.size() == given.length) {
			ans.add(new ArrayList(temp));
			return;
		}
		for (int i = 0; i < given.length; i++) {
			if (temp.contains(given[i]))
				continue;
			temp.add(given[i]);
			buildList(given, ans, temp);
			temp.remove(temp.size() - 1); // backtrack
		}
	}

}
