package LeetCode;

import java.util.Arrays;

public class Prob561_ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i=i+2){
            ans += nums[i];
        }
        return ans;
    }
}

/*
sort and sum of every odd num in the pairs...

-49,0,4,9,13,21

-49   -49
4     0
13    4
a
*/