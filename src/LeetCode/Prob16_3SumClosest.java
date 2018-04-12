package LeetCode;

import java.util.Arrays;

public class Prob16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int sum = nums[0]+nums[1]+nums[2];
        for (int i = 0; i < nums.length-2; i++) {
            int first = i+1, last = nums.length-1;
            while (first < last) {
                int tsum = nums[i]+nums[first]+nums[last];
                if (tsum == target) return tsum;
                if (Math.abs(target-tsum) < Math.abs(target-sum))
                    sum = tsum;
                if (tsum < target) first++;
                else last--;
            }
        }
        return sum;
    }
}

/*
[-3,-2,-5,3,-4]
[-5,-4,-3,-2,3] -1

{-1 2 1 -4} target = 1
-4,-1,1,2
    ^ ^ ^
tsum = -3 target =1 sum =max
1--3 = 4 = sum = -3

tsum = -1
1--1 =2 < 3
sum = -1 = tsum


*closest* sum
O(n^3):
from i 0 to end
    from j 0 to end
        from k 0 to end
            if any of them are same indices then skip current iteration
            calc sum and if its closer to target than current sum then make it current sum
return current sum

two pointer way: O(n^2)
sort
from i 0 to end-2
first = i+1, last = len-1
sum = max int
while (first < last){
    if sum of i, first, last == sum then return sum
    if sum is less than target:
        first++
    if sum > target:
        last--
        
bin search way: O(n^2) - worst case would still be same
sort
take middle element
if middle > target
    search for the 3 elements in the first half
else if middle < target
    search for the 3 elements in the second half
else
    search for the 3 element throughout
}
*/