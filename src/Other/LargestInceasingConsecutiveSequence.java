package Other;

public class LargestInceasingConsecutiveSequence {
	
	/*
	 * O(n^2) way: look at each window and calc sum and return the largest sum
	 * O(n) way:
	 * bestSum = runningSum = arr[i]
	 * 
	 * every iteration:
	 * 	runningSum += arr[i]
	 * 	if (arr[i] > runningSum)
	 * 		runningSum = arr[i]
	 *  if (runningSum > bestSum)
	 *  	bestSum = runningSum
	 *  
	 *  5 -1 -3 2 4 -3 2
	 *  ^
	 *  1 -1 -3 2 4 -3 2
	 *                 ^
	 *            ^
	 */
	public static int largestSumConsecutiveSequence(int[] arr) {
		if (arr == null) throw new NullPointerException();
		if (arr.length == 0) return 0;
		int bestSum=arr[0], runningSum=arr[0];
		for (int i = 1; i < arr.length; i++) {
			runningSum += arr[i];
			if (arr[i] > runningSum)
				runningSum = arr[i];
			if (runningSum > bestSum)
				bestSum = runningSum;
		}
		return bestSum;
	}
	
	public static void main(String[] args) {
		System.out.println(largestSumConsecutiveSequence(new int[] {5,-1,-3,2,4,-3,2}));
		System.out.println(largestSumConsecutiveSequence(new int[] {1,-1,-3,2,4,-3,2}));
		System.out.println(largestSumConsecutiveSequence(new int[] {-1,0,1}));
		System.out.println(largestSumConsecutiveSequence(new int[] {0,0,0,0,0,-2,-5,-1}));
		System.out.println(largestSumConsecutiveSequence(new int[] {-1,-2,-3,-4,2}));
		System.out.println(largestSumConsecutiveSequence(new int[] {5,-2,3}));
		System.out.println(largestSumConsecutiveSequence(new int[] {5}));
	}
}
