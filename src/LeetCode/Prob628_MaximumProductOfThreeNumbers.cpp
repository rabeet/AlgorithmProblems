class Solution {
public:
    
    // keep a running total of the 3 max numbers and 2 min numbers
    int maximumProduct(vector<int>& nums) {
        int max1=-1001, max2=-1001, max3=-1001;
        int min1=1001, min2=1001;
        int len = nums.size();
        for (int i = 0; i < len; i++) {
            // cout << max1 << max2 << max3 <<endl;
            if (nums[i] >= max3) {
                max1 = max2;
                max2 = max3;
                max3 = nums[i];
            } else if (nums[i] >= max2) {
                max1 = max2;
                max2 = nums[i];
            } else if (nums[i] >= max1) {
                max1 = nums[i];
            } 
            if (nums[i] <= min2) {
                min1 = min2;
                min2 = nums[i];
            } else if (nums[i] <= min1) {
                min1 = nums[i];
            }
        }
        int p1 = max1*max2*max3;
        int p2 = max3*min1*min2;
        return max(p1,p2);
    }
};