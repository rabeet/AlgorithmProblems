package LeetCode;

import java.util.Arrays;

public class Prob322_CoinChange {

    public static void main(String[] args) {
        Prob322_CoinChange p = new Prob322_CoinChange();
        System.out.println(p.coinChangeRecursive(new int[]{1,2,5}, 11));
        System.out.println(p.coinChangePureRecursive(new int[]{1,2,5}, 11));
        System.out.println(p.coinChangeDynamic(new int[]{1,2,5}, 11));
        System.out.println(p.coinChangeDynamicBottomUp(new int[]{1,2,5}, 11));
    }

    // remainder, number of tries to get to remainder will be the memoization table
    /*
    start at i= 0 -> end-1:
        min # of coins to get to 11-1


     */

    public int coinChangeDynamic(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        return coinChangeDynamic(coins, amount, dp);
    }


    /*
    1,2,5; 11
    0,1,2,3,4,5,6,7,8,9,10,11
      ^ ^ ^ ^ ^ ^ ^ ^ ^ ^  ^
      1 1 2 2 1 2 2 3 3 2  3


    for each int: i in rem
        for each coin:
            min coins needed to get to get to i using rem[i-coin]

    if rem[amount] is 0 return -1 else return rem[amount]
     */
    private int coinChangeDynamicBottomUp(int[] coins, int amount) {
        if (amount <0 || coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        int[] rem = new int[amount+1];
        Arrays.fill(rem, amount+1);
        rem[0] = 0;
        for (int i = 1; i <rem.length; i++) {
            for (int coin : coins) {
                if (i == coin) {
                    rem[i] = 1;
                    break;
                }
                int temp = i - coin;
                if (temp > 0) {
                    rem[i] = Math.min(rem[i], rem[temp]+1);
                }
            }
        }
        System.out.println(Arrays.toString(rem));
        return rem[amount] == amount+1 ? -1 : rem[amount];
    }

    // Top Down - number of tries to get to the remainder
    private int coinChangeDynamic(int[] coins, int amount, int[] rem) {
        if (amount < 0 || coins == null || coins.length == 0) return -1;
        if (amount == 0) return 0;
        if (rem[amount] != 0) return rem[amount];
        int t = Integer.MAX_VALUE;
        for (int coin : coins) {
            int next = coinChangeDynamic(coins, amount-coin, rem);
            if (next != -1) {
                t = Math.min(1 + next, t);
            }
        }
        rem[amount] = t== Integer.MAX_VALUE ? -1 : t;
        return rem[amount];
    }

    private int coinChangePureRecursive(int[] coins, int amount) {
        if (amount < 0 || coins == null || coins.length == 0) return -1;
        if (amount == 0)
            return 0;
        int t = Integer.MAX_VALUE;
        for (int coin : coins) {
            int next = coinChangePureRecursive(coins, amount-coin);
            if (next != -1) {
                t = Math.min(t, 1+next);
            }
        }
        return t == Integer.MAX_VALUE ? -1 : t;
    }

    public int coinChangeRecursive(int[] coins, int amount) {
        if (amount <= 0 || coins == null || coins.length == 0) return 0;
        coinChangeRecursive(coins, amount, 0);
        int temp = min;
        min=-1;
        return temp;
    }

    private static int min = -1;

    private void coinChangeRecursive(int[] coins, int amount, int tries) {
        if (amount < 0 || coins == null || coins.length == 0) return;
        if (amount == 0)
            min = min == -1? tries : tries < min ? tries:min;
        for (int coin : coins)
            coinChangeRecursive(coins, amount-coin, tries+1);
    }
}


/*
1,2,5; 6
1,1,1,1,1,1
 */