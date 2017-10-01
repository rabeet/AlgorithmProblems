package LeetCode;

public class Prob53_MaximumSubArray {
	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length < 1)
			return -1;
		int maxSoFar = 0, bestMax = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] + maxSoFar > nums[i])
				maxSoFar += nums[i];
			else
				maxSoFar = nums[i];
			// if the subarray keeps increasing in size and is greater than the
			// bestMax then add it to the bestMax
			if (maxSoFar > bestMax)
				bestMax = maxSoFar;
			// otherwise maxSoFar = nums[i]
		}
		return bestMax;
	}

	public int maxSubArraySLOW(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int bestMax = Integer.MIN_VALUE;
		// [-2,1,-3,4,-1,2,1,-5,4]

		// O(n^2)
		for (int i = 0; i < nums.length; i++) {
			int curMax = 0;
			for (int j = i; j < nums.length; j++) {
				curMax += nums[j];
				if (curMax > bestMax)
					bestMax = curMax;
			}
		}
		return bestMax;
	}
}
