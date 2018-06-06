package LeetCode;

public class Prob41_FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;
        for (int i = 0; i < n; i++) {
            while(nums[i] != i+1 && nums[i] > 0 && nums[i] <= n) {
                if (nums[nums[i]-1] != nums[i])
                    swap(nums, nums[i]-1, i);
                else
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i+1) return i+1;
        }
        return n+1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}

/*
3,4,-1,1
-1,4,3,1
-1,1,3,4
1,-1,3,4

*/