package LeetCode;

public class Prob121_BestTimeToBuyAndSellStock {
	
	public int maxProfit(int[] prices) {
        // traverse the array while keeping track of the min and the max. at the end of the arr if max index is less than min index then return 0 otherwise return the difference of 2
        if (prices == null) return 0;
        if (prices.length <= 1) return 0;
        int minIndex=0;
        int maxProfit=0;
        
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]-prices[minIndex] > maxProfit) maxProfit = prices[i]-prices[minIndex];
            else {
                minIndex = prices[i] < prices[minIndex]? i:minIndex;
            }
        }
        
        return maxProfit;
    }
}

// 0, 0, 1, 1, 5 = 4
// 1,2,3,4,5,6 = 5
// 5,4,3,2,1 = 0
// 7, 20, 2, 9, 1, 6 = 13
