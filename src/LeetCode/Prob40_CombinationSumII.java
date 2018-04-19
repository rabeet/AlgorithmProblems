package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob40_CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(candidates);
        if (candidates == null || candidates.length == 0) return ans;
        populateList(candidates, ans, new ArrayList<Integer>(), target, 0);
        return ans;
    }
    
    private void populateList(int[] candidates, List<List<Integer>> ans, List<Integer> built, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            List<Integer> ret = new ArrayList(built);
            if (!ans.contains(ret)) ans.add(ret);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            built.add(candidates[i]);
            populateList(candidates, ans, built, target-candidates[i], i+1);
            built.remove(built.size()-1);
        }
    }
}