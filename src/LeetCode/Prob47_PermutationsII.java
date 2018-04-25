package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prob47_PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) return ans;
        permuteUnique(nums, new HashSet<Integer>(), new ArrayList<Integer>(), ans);
        return ans;
    }

    private void permuteUnique(int[] nums, Set<Integer> set, List<Integer> built_list, List<List<Integer>> ans) {
        if (built_list.size() == nums.length) {
            if (!ans.contains(built_list)) {
                ans.add(new ArrayList(built_list));
            }
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) continue;
            built_list.add(nums[i]);
            set.add(i);
            permuteUnique(nums, set, built_list, ans);
            set.remove(i);
            built_list.remove(built_list.size()-1);
        }
    }

    /*
    1,1,2
    ans:1,1,2;1,2,1;
    set: 1,0,2
    list:1,1,2

    */

}