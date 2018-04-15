package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList();
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        int n = nums.length;
        for (int i = 0; i < n-3; i++) {
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target)break; //first candidate too large, search finished
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target)continue; //first candidate too small
            if(i>0 && nums[i]==nums[i-1]) continue; // just needed this one to prevent dupes - the i>0 allows ONE process
            for (int j = i+1; j < n-2; j++) {
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target)break; //second candidate too large
                if(nums[i]+nums[j]+nums[nums.length-1]+nums[nums.length-2]<target)continue; //second candidate too small
                if(j>i+1&&nums[j]==nums[j-1]) continue; // just needed this one to prevent dupes - the j>i+1 allows ONE process
                int first = j+1, last = n-1;
                while (first < last) {
                    int sum = nums[i]+nums[j]+nums[first]+nums[last];
                    if (sum == target) {
                        ans.add(Arrays.asList(new Integer[]{nums[i],nums[j],nums[first],nums[last]}));
                        while (first < last && nums[first] == nums[first+1]) first++;
                        while (first < last && nums[last] == nums[last-1]) last--;
                        first++;
                        last--;
                    } else if(sum < target) {
                        first++;
                    } else {
                        last--;
                    }
                }
            }
        }
        return ans;
    }
}

/*
O(n^4) solution:
4 for eaches lol and skipping same indices..

Got it right but needed the optimizations (the TS still does not change!! wtf)
Sorting way O(n^3):
check null and valid size
Sort
pointer i 0 -> n-3
if i > 0 and current i is equal to the last i then continue
    pointer j i+1 -> n-2
    if j > i+1 and current j is equal to the last j then continue
        pointer first = j+1
        pointer last = n-1
        while(first is less than last)
            if sum of all pointers is target:
                add sum to ans list
                while(first < last && first == first+1)
                    first++
                while(first < last && last == last-1)
                    last--
                first++ and last--
            else if sum is less than target
                first++
            else last--
return answer list

[1,2,0,0,-1,5,-5,-1]
[-5,-1,-1,0,0,1,1,2,5] 0

[1,0,-1,0,-2,2]
[-2,-1,0,0,1,2]

*/