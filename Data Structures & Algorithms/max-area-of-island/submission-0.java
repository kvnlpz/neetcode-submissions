class Solution {

    private int maxArea = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                int currentArea = dfs(grid, row, column);
                maxArea = Math.max(currentArea, maxArea);
            }
        }
        return maxArea;
    }


    private int dfs(int[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == 0) {
            return 0;
        }


        grid[row][column] = 0;

        int area = 1;
        area += dfs(grid, row+1, column);
        area += dfs(grid, row-1, column);
        area += dfs(grid, row, column+1);
        area += dfs(grid, row, column-1);
        return area;
    }
}
