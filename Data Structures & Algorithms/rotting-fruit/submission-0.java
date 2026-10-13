class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int rows = grid.length;
        int columns = grid[0].length;
        int freshFruits = 0;
        int minutes = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == 1) {
                    // we found fresh fruit so log it. 
                    freshFruits++;
                }
                else if (grid[row][column] == 2) {
                    // we found a rotten fruit so we have to store the location
                    queue.offer(new int[]{row, column});
                }
            }
        }

        // Now that we went through that and logged everything, now we gotta do the BFS

        while (freshFruits > 0 && !queue.isEmpty()) {
            // get a snapshot of how many rotting fruits are currently in it (because we add more)
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                int currentRow = current[0];
                int currentColumn = current[1];
                
                for (int[] direction : directions) {
                    int nextRow = currentRow + direction[0];
                    int nextColumn = currentColumn + direction[1];

                    if (nextRow >= 0 && nextColumn >= 0 && nextRow < grid.length && nextColumn < grid[0].length && grid[nextRow][nextColumn] == 1) {
                        // We found a fresh fruit that we're going to be rotting so set it equal to 2
                        grid[nextRow][nextColumn] = 2;
                        queue.offer(new int[]{nextRow, nextColumn});
                        freshFruits--;
                    }
                }
            }
            // Every time we complete a loop, a minute passes
            minutes++;
        }
        if (freshFruits == 0) return minutes;
        else return -1;
    }
}
