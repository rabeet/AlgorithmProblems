package LeetCode;
import java.util.Arrays;

public class Prob167_TwoSumII {
	public static void main(String[] args) {
		Prob167_TwoSumII prob = new Prob167_TwoSumII();
		System.out.println(Arrays.toString(prob.twoSum(new int[]{1 , 2, 3, 84}, 287)));
		System.out.println(Arrays.toString(prob.twoSumTwoPointers(new int[]{1 , 2}, 3)));
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] ans = new int[2];
		ans[0] = -1; ans[1] = -1;
		for (int i = 0; i < nums.length; i++) {
			int num1 = nums[i];
			int num2 = binarySearch(nums, target-num1, i+1, nums.length-1);
			if (num2 == -1)
				continue;
			else {
				ans[0] = i+1;
				ans[1] = num2+1;
			}
		}
		return ans;
	}

	public int binarySearch(int nums[], int target, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end)/2;
		return (nums[mid] == target) ? mid : target > nums[mid] ? binarySearch(nums, target, mid+1, end) : binarySearch(nums, target, start, mid-1);
	}
	
	public int[] twoSumTwoPointers(int[] nums, int target) {
		int ans[] = new int[2];
		ans[0] = -1; ans[1] = -1;
		if (nums.length < 2)
			return ans;
		int start = 0, end = nums.length -1;
		while (start < end) {
			int sum = (nums[start] + nums[end]);

			if ( sum == target) {
				ans[0] = start + 1;
				ans[1] = end + 1;
				break;
			}
			else {
				if (target > sum)
					start++;
				else
					end--;
			}
		}

		return ans;
	}

}
