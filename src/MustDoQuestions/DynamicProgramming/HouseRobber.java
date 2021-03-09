package MustDoQuestions.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {

    // given a list of profit of each house, return max of entire robbing spree by only robbing non adjacent houses
    public static void main(String[] args) {
        int[] houses = {1, 2, 3, 8, 5,10,12,4,9,2,6,7,9,5,12,33,12,8,12,33,12,8,12,33,12,8,12,33,12,8,12,33,12,8,12,33,12,8,12,33,12,8,12};
        long time = System.currentTimeMillis();
        System.out.println(maxRobbingRecursive(houses) + " " + (System.currentTimeMillis()-time));
        time = System.currentTimeMillis();
        System.out.println(maxRobbingRecursiveWithMemo(houses) + " " + (System.currentTimeMillis()-time));
    }

    public static int maxRobbingRecursive(int[] profit) {
        int max = 0;
        for (int i = 0; i < profit.length; i++) {
            max = Math.max(max, maxRobbingRecursive(profit, i));
        }
        return max;
    }

    private static int maxRobbingRecursive(int[] profit, int i) {
        int max = profit[i];
        for (int j = i+2; j < profit.length; j++) {
            max = Math.max(max, profit[i] + maxRobbingRecursive(profit, j));
        }
        return max;
    }

    public static int maxRobbingRecursiveWithMemo(int[] profit) {
        int max = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        for (int i = 0; i < profit.length; i++) {
            max = Math.max(max, maxRobbingRecursive(profit, i, memo));
        }
        return max;
    }
    // with memoize
    private static int maxRobbingRecursive(int[] profit, int i, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        int max = profit[i];
        for (int j = i+2; j < profit.length; j++) {
            max = Math.max(max, profit[i] + maxRobbingRecursive(profit, j));
        }
        memo.put(i, max);
        return max;
    }

}
