package LeetCode;

public class Prob204_CountingPrimes {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        Integer[] nums = new Integer[n];
        for (int i = 2; i < n; i++)
            nums[i] = i;
        for (int i = 2; i <= n >> 1; i++) {
            for (int j = i*2; j < n; j += i)
                nums[j] = null;
        }
        int count = 0;
        for (Integer i : nums)
            if (i != null) count++;

        return count;
    }
}

/*
Sieve of Erasthoteses:
from 2 to n-1: (i)
    Put the number in array

from 2 to sqrt(n): (x)
    remove all multiples of x from the array


*/