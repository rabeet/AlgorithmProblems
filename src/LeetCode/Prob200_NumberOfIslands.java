package LeetCode;

public class Prob200_NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visit(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void visit(char[][] grid, boolean[][] visited, int x, int y) {
        if (grid[x][y] == '0' || visited[x][y]) return;
        visited[x][y] = true;
        if (x+1 < grid.length) visit(grid, visited, x+1, y);
        if (x-1 >= 0) visit(grid, visited, x-1, y);
        if (y+1 < grid[0].length) visit(grid, visited, x, y+1);
        if (y-1 >= 0) visit(grid, visited, x, y-1);
    }
}


/*
Keep a visited 2d array to show which ones are visited.
count = 0;
for each element in matrix:
    if its land, do a bfs visiting adjacent land mass and adjusting the visited flag
    count++;
return count;
*/
