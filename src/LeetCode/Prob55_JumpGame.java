package LeetCode;

public class Prob55_JumpGame {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        boolean[] R = new boolean[nums.length];
        R[0] = true;
        for (int i = 0; i < nums.length-1; i++) {
            if(!R[i]) break;
            for (int j=i; j<=i+nums[i];j++) {
                R[j] = true;
                if (j == nums.length - 1) return true;
            }
        }

        return R[R.length-1];
    }

}

/*
2,3,1,1,4
2 to 1 to 1 to 4
2 to 3 to 4 or 1 to to 1

recursive:
    end if reached the end or at 0
    start at j:
        from j call same func on on each interval to the last possible one

*/
