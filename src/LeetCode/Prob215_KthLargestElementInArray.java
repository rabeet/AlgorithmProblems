package LeetCode;

import java.util.Arrays;

public class Prob215_KthLargestElementInArray {
	
	
	// 2 phase approach - considering duplicates in the array: O(n log n)
    // phase 1: sort the array.
    // phase 2: find the kth largest from the end:
    /*  pointer = last item in sorted array
        if (k == 1) return arr[pointer]
        else {
            pointer--;
            if (arr[pointer] != arr[pointer-1]) k--;
        }
        
        TC1 : [3,2,1,5,6,4], 2 -> 5
        TC2: [3,2,1,5,6,4], 3 -> 4
        TC3: [3,2,1,5,6,4],14 -> -1
        TC4: [3,2,1,5,6,4], 6 -> 1
        TC5: [1,1,1,0], 2 -> 0
        TC6: [1,1], 1 -> 1
        TC7: [1,2,2,5,3], 3 -> 2
        
        TODO: Learn QuickSelect approach: https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/
    */
	
	public int findKthLargest(int[] nums, int k) {
        if (nums == null) return -1;
        if (k > nums.length || nums.length < 1) return -1;
        // phase 1
        Arrays.sort(nums);
        
        // phase 2
        for (int i = nums.length-1; i >= 0; i--) {
            if (i != nums.length -1) {
                k--;
            }
            if (k == 1) return nums[i];
        }
        return -1;
    }
}
