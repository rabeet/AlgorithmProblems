package LeetCode;

public class Prob122_BestTimeToBuyAndSellStockII {
	// 3 different variables. current min, current max and max profit
	// also if you just keep adding every uptick it will work as well.
	public int maxProfit(int[] prices) {
		if (prices == null)
			return 0;
		if (prices.length == 0)
			return 0;
		// [7,17,19,1,5,9,21] --> 5-1 + 21-9 OR 21-1
		// [1,2,9,10,8] --> 4 + 8 = 12
		// keep track of the current max, current min, profit
		int curMax = 0, curMin = 0, maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > prices[curMax])
				curMax = i;
			if (prices[i] < prices[curMax]) { // cash out
				maxProfit += prices[curMax] - prices[curMin];
				curMin = i;
				curMax = i;
			}
			if (i == prices.length - 1) {
				if (curMin != i)
					maxProfit += prices[curMax] - prices[curMin];
			}
		}
		return maxProfit;
	}
}
