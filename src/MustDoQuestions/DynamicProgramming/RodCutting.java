package MustDoQuestions.DynamicProgramming;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class RodCutting {

    /*
    Given rod length n and map with cuts and prices for each cut, return the max possible profit to cut entire rod
     */

    public static void main(String[] args) {
        Map<Integer, Integer> prices = Map.of(1, 2, 2, 4, 4, 6);
        int rod = 5;
        long time = System.currentTimeMillis();
        System.out.println(maxProfitForCutBottomUp(rod, prices) + " " + (time-System.currentTimeMillis()));
        time = System.currentTimeMillis();
        System.out.println(maxProfitForCutTopDown(rod, prices) + " " + (time-System.currentTimeMillis()));
    }

    public static int maxProfitForCutBottomUp(int rod, Map<Integer, Integer> prices) {
        int[] dp = new int[rod + 1];

        for (int i = 1; i < dp.length; i++) {
            for (Map.Entry<Integer, Integer> pc : prices.entrySet()) {
                int cut = pc.getKey(), pr = pc.getValue();
                if (cut <= i) {
                    dp[i] = Math.max(dp[i], dp[i-cut]+pr);
                }
            }
        }

        return dp[rod];
    }

    // TODO fix this
    public static int maxProfitForCutTopDown(int rod, Map<Integer, Integer> prices) {
        Queue<int[]> q = new LinkedList<>();
        int maxProfit = 0;
        q.offer(new int[]{rod,0});
        var cutPrices = new HashMap<Integer, Integer>();
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int leftoverWood = temp[0], priceOfLeftover = temp[1];
            if (leftoverWood == 0) {
                maxProfit = Math.max(maxProfit, priceOfLeftover);
            } else {
                for (Map.Entry<Integer, Integer> entry : prices.entrySet()) {
                    Integer cut = entry.getKey();
                    Integer priceOfCut = entry.getValue();
                    if (leftoverWood - cut >= 0) { // if is a possible cut
                        if (cutPrices.containsKey(leftoverWood - cut)) {
                            if (cutPrices.get(leftoverWood - cut) >= priceOfLeftover + priceOfCut) {
                                q.offer(new int[]{0, cutPrices.get(leftoverWood - cut) + priceOfCut});
                            } else {
                                q.offer(new int[]{leftoverWood - cut, priceOfCut + priceOfLeftover});
                                cutPrices.put(leftoverWood - cut, priceOfCut + priceOfLeftover);
                            }
                        } else {
                            q.offer(new int[]{leftoverWood - cut, priceOfCut + priceOfLeftover});
                            cutPrices.put(leftoverWood - cut, priceOfCut + priceOfLeftover);
                        }
                    }
                }
            }
        }

        return maxProfit;
    }
}
