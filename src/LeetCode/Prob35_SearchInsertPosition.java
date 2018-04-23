package LeetCode;

public class Prob35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                return i;
        }
        return nums.length;
    }
}

/*
Keep iterating unless:
    target is found then return that index
    nums[i] is > target then return i
return nums.length
*/
