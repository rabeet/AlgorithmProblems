package LeetCode;

public class Prob152_MaximumProductSubarray {

    public static void main(String[] args) {
        Prob152_MaximumProductSubarray p = new Prob152_MaximumProductSubarray();
        System.out.println(p.maxProduct(new int[]{2,5,-1,2}));
        System.out.println(p.maxProduct(new int[]{2,5,-1,312}));
        System.out.println(p.maxProduct(new int[]{-2,0,-1}));
        System.out.println(p.maxProduct(new int[]{-2,-5,-4,2}));
        System.out.println(p.maxProduct(new int[]{2,51,3,-1,52,-1,3,-2,-5,-4,2}));
    }

    public int maxProduct(int[] nums) {
        // TODO: Single pass, at each iteration maintain max, min, nums[i] and at each iteration result is the bigger of the 3
        // we have to compare among max * A[i], min * A[i] as well as A[i], since this is product, a negative * negative could be positive.
        return Math.max(maxProduct(nums, true), maxProduct(nums, false));
    }

    private int maxProduct(int[] nums, boolean direction) {
        if (nums.length == 1) return nums[0];
        int total_prod = 0, max = Integer.MIN_VALUE, total_pos_prod = 0;
        for (int i = direction? 0:nums.length-1; i < nums.length && direction || i>= 0 && !direction; i=direction?i+1:i-1) {
            if (total_prod == 0) total_prod = nums[i];
            else total_prod *= nums[i];
            max = Math.max(max, Math.max(total_prod, total_pos_prod));
        }
        return max;
    }

/*

ONE SWEEP FROM LEFT TO RIGHT AND ANOTHER FORM RIGHT TO LEFT

  2,    3,      -2,         4
 2,2,2 6,6,6   0,-12,6   4,-48,6

tp=0, max=min, tpp=0



O(n^2)
max = min_int
for each int i = 0 -> end-1
    for each j = i -> end-1
        if subarray i to j exceeds max then max = subarray i to j

0 separates the max so far
keep +ve total, keep -ve total in hopes of seeing a -ve again later
if we hit 0 the max is the +ve total and reset the +ve total and -ve total

total_prod = 0
max = min_integer
from i = 0 to end-1:
    if ar[i] = 0
        if total_prod < 0 then max = 0
            total_prod = 0;
    else
        if total_prod == 0 then total_prod = ar[i]
        else total_prod *= ar[i]
        if max <= tp then max = tp

return max
*/
}

