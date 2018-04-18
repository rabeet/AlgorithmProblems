package LeetCode;

import java.util.Arrays;

public class Prob31_NextPermutation {
    
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        for (int i = len-1; i >= 1; i--) {
                if (nums[i] > nums[i-1]) {
                int smallestIndex= 0;
                for (int j = len-1; j > i-1; j--) {
                    if (nums[j] > nums[i-1]) {
                        smallestIndex = j;
                        break;
                    }
                }
                int temp = nums[i-1];
                nums[i-1] = nums[smallestIndex];
                nums[smallestIndex] = temp;
                reverse(nums, i, len-1);
                return;
            }
        }
        reverse(nums);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    private void reverse(int[] nums) {
        reverse(nums, 0, nums.length-1);
    }
    
    public void nextPermutationSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        int len = nums.length;
        for (int i = len-1; i>=1; i--) {
            if (nums[i] > nums[i-1]) {
                int smallest = nums[i];
                int smallestIndex = i;
                for (int j = i; j < len; j++) {
                    if (nums[j] > nums[i-1] && nums[j] < smallest) {
                        smallest = nums[j];
                        smallestIndex = j;
                    }
                }
                int temp = nums[i-1];
                nums[i-1] = nums[smallestIndex];
                nums[smallestIndex] = temp;
                Arrays.sort(nums, i, len);
                return;
            }
        }
        Arrays.sort(nums);
    }
}

/*
1,4,1,2; 1,4,2,1
4,3,1,2; 4,3,2,1
5,15,1,0; 15,0,1,5
5,3,2,1; 1,2,3,5
7,1,2,4,4,2,1; 7,1,3,1,2,2,3
3,1,2;  3,2,1
4,1,3,2,1;  4,2,1,3

base and null checks
from i = len-1 to 1
    if (arr[i] > arr[i-1])
        find smallest number bigger than arr[i-1] from i
        swap arr[smallest] and arr[i-1] and sort from i to len if valid
        return;
    end if
end for
sort
*/