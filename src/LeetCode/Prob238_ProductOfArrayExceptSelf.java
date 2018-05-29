package LeetCode;

public class Prob238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        if (n == 0) return ans;
        ans[0] = 1;
        for (int i = 1; i < n; i++)
            ans[i] = ans[i-1]*nums[i-1];
        int right_prod = 1;
        for (int i = n-2; i >= 0; i--) {
            right_prod *= nums[i+1];
            ans[i] *= right_prod;
        }
        return ans;
    }
}

/*
Brute force : O(n^2):
    for each:
        for each except self:
            multiply the number and add it to the ith element


2 Arrays: O(n) O(n)
array1: prod to the left of index
array2: prod to the right of index
ans = array1*array2

1 Array: O(n) O(1)
array: prod to the left of index
right_prod=maintain the prod to the right with one integer starting with 1
ans = array1*right_prod

BFS: O(n^2) O(n)
for each elem do a bfs to its left and right until boundaries are hit
^


*/
