class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int columns = grid[0].length;
        int islandsFound = 0;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1') {
                    dfs(grid, row, column);
                    islandsFound++;
                }
            }
        }    
        return islandsFound;
    }


    private void dfs(char[][] grid, int row, int column) {
        // Check if out of bounds
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length || grid[row][column] == '0') {
            return;
        }
        
        // if we made it this far, we can process the next nearest coordinates
        
        // change current coordinate's value to avoid re-processing
        grid[row][column] = '0';

        // recurse through neighbors
        dfs(grid, row+1, column);
        dfs(grid, row-1, column);
        dfs(grid, row, column+1);
        dfs(grid, row, column-1);
    }
}
