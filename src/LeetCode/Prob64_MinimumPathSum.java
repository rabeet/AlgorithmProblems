package LeetCode;

public class Prob64_MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null) return -1;
        for (int i = 1; i < grid.length; i++){
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < grid[0].length; i++){
            grid[0][i] += grid[0][i-1];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

/*
Recursive soln:
    base case:
        if reached the bot right cell, see if sum is smaller than the one saved previously, if so then save it
        if reached invalid location go back
    make 2 recusrive calls from each cell, bot and right increasing sum by the amount


top down recursive:
    f (0,0) = grid[0][0]
    f (x,0) = grid[x][0] + grid[x-1][0]
    f (0,x) = grid[0][x] + grid[0][x-1]
    f(x,y) = grid[x][y] + min(f(x-1, y), f(x, y-1))

    return f(len-1,len-1);

[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]


*/
}
