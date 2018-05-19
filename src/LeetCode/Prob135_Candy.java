package LeetCode;

import java.util.Arrays;
public class Prob135_Candy {

    public int candy(int[] ratings) {

        int n = ratings.length;
        if (n == 1) return 1;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }

        for (int i = n -2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += candies[i];
        return sum;
    }

    public int candy2Arrays(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i-1]) {
                left[i] = left[i-1]+1;
            }
        }
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right[i] = right[i+1]+1;
            }
        }
        for (int i = 0; i < n; i++)
            sum += Math.max(right[i], left[i]);
        return sum;
    }

    public int candyTLE(int[] ratings) {
        int n = ratings.length;
        if (n == 1) return 1;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    if (ratings[j] > ratings[j+1] && candies[j] <= candies[j+1])
                        candies[j]++;
                } else if (j == n-1) {
                    if (ratings[j] > ratings[j-1] && candies[j] <= candies[j-1])
                        candies[j]++;
                } else {
                    if (ratings[j] > ratings[j+1] && candies[j] <= candies[j+1] || ratings[j] > ratings[j-1] && candies[j] <= candies[j-1])
                        candies[j]++;
                }
            }
        }
        // System.out.println(Arrays.toString(candies));
        int sum = 0;
        for (int i : candies)
            sum += i;
        return sum;
    }
}