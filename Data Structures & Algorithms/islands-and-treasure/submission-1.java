class Solution {
    private static final int[][] DIRECTIONS = {
        {-1,0}, {1,0}, {0, -1}, {0, 1}
    };
    private static final int TREASURE = 0;
    private static final int LAND_CELL = Integer.MAX_VALUE;


    public void islandsAndTreasure(int[][] grid) {
        // check if grid is null or empty - dont do extra work 
        if (grid == null || grid.length == 0) return;
        
        int rows = grid.length;
        int columns = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == TREASURE) {
                    queue.offer(new int[]{row, column});
                }
            }
        }

        // Now expand outward
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int column = current[1];

            for (int[] direction : DIRECTIONS) {
                int rowOffset = direction[0];
                int columnOffset = direction[1];
                
                // now calc the next row and column
                int nextRow = rowOffset + row;
                int nextColumn = columnOffset + column;
                // skip if we're out of bounds or if we're anything other than a land cell
                if (nextRow < 0 || nextColumn < 0 || 
                nextRow >= grid.length || nextColumn >= grid[0].length 
                || grid[nextRow][nextColumn] != LAND_CELL) {
                    continue;
                }

                grid[nextRow][nextColumn] = grid[row][column] + 1;
                queue.add(new int[]{nextRow, nextColumn});
            


            }

            


        }
         
    }
}
