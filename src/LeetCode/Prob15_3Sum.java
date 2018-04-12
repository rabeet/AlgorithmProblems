package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob15_3Sum {
	
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            if (nums[i] > 0) break;
            int j = i+1;
            int last = nums.length-1;
            while (last > j) {
                int sum = nums[i]+nums[j]+nums[last];
                if (sum > 0) last--;
                else if (sum < 0) j++;
                else {
                    List l = Arrays.asList(new Integer[]{nums[i],nums[j],nums[last]});
                    ans.add(l);
                    while (j < last && nums[j] == nums[j+1]) j++;
                    while (j < last && nums[last] == nums[last-1]) last--;
                    last--;
                    j++;
                }
            }
        }
        return ans;
    }
}

/*
Sorting way, 3 pointer:
    Sort array
    Set two pointers at i=0 and j=1, set last pointer at end
    Until sum=0 is found or last pointer meets the j:
        keep adjusting both pointers according to the min max of 0
    Move two front pointers by 1
    Can end when the two pointers can no longer progress
    
[-1,0,1,2,-1,-4],
sort:
[-4,-1,-1,0,1,2]

[-4,-3,-1,-7]
sort"
[-7,-3,-4,-1]
        ^  ^  ^     
        
[-4,-3,-1,-7,6,1]
[-7,-4,-3,-1,1,6]
*/