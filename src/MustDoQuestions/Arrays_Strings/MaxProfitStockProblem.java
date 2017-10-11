package MustDoQuestions.Arrays_Strings;

public class MaxProfitStockProblem {

	public static void main(String[] args) {
		// given an array representing stock prices at that day
		// find the max profit with buying at a day and selling at a day
		System.out.println(maxProfit(new int[]{7,2,5,1,9,8,3,7}));
		System.out.println(maxProfit(new int[]{1,2,3,4,5,6,7}));
		System.out.println(maxProfit(new int[]{5,4,1}));
		System.out.println(maxProfit(new int[]{2,5,1,2,3}));
		System.out.println(maxProfit(new int[]{1}));
		
		
		// PART 2:
		// given an array representing stock prices at that day
		// find the max profit with buying at a day and selling at a day
		// can make multiple buy-sell
		System.out.println(maxProfit2(new int[]{7,2,5,1,9,8,3,7}));
		System.out.println(maxProfit2(new int[]{2,5,1,2,3}));
	}
	
	public static int maxProfit(int[] arr) {
		
		/*
		 * keep track of max profit and min index and iterate:
		 * if the arr[i]-arr[min] is greater than max profit then update it
		 * if arr[min] is greater than arr[i] then update min
		 * 
		 * prices:  7 2 5 1 9 8 3 7; profit = 8
		 * prices: 1 2 3 4 5 6 7; proft = 6
		 * prices: 5,4,1; profit = 0
		 * prices: 2,5,1,2,3; profit = 3 
		 * prices: 1; profit = 0
		 * 
		 */
		int maxprofit = 0, minIndex = 0;
		for (int i = 0;  i < arr.length; i++) {
			if (arr[i]-arr[minIndex] > maxprofit) maxprofit = arr[i]-arr[minIndex];
			
			if (arr[minIndex] > arr[i]) minIndex = i;
		}
		return maxprofit;
	}
	
	
	// the idea is to basically sell whenever you can
	public static int maxProfit2(int[] arr) {
		int maxProfit = 0, minIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - arr[minIndex] > 0) {
				maxProfit += (arr[i]-arr[minIndex]);
				minIndex = i; // old min index is invalidated
			}
			if (arr[i] < arr[minIndex]) minIndex = i;
		}
		return maxProfit;
	}

}
