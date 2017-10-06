package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Prob39_CombinationSum {
	
	public static void main(String[] args) {
		int[] candidates = {2,2,3,7};
		List<List<Integer>> ans = combinationSum(candidates, 7);
		for (List l : ans)
			System.out.println(l);
	}
	
	public static  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

	
	// 2 3 7 6 --> 7
	private static void backtrack(List<List<Integer>> ans, List<Integer> tempList, int[] candidates, int track, int target) {
		if (track < 0) return;
		if (track == 0) {
			ans.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = target; i < candidates.length; i++) {
			if (track - candidates[i] < 0) continue;
			tempList.add(candidates[i]);
			backtrack(ans, tempList, candidates, track-candidates[i], i+1);
			tempList.remove(tempList.size()-1);
		}
	}
}
