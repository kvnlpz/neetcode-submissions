class Solution {

    static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) return new ArrayList<>();

        final int ROWS = heights.length;
        final int COLUMNS = heights[0].length;

        boolean[][] canReachPacific = new boolean[ROWS][COLUMNS];
        boolean[][] canReachAtlantic = new boolean[ROWS][COLUMNS];

        for (int column = 0; column < COLUMNS; column++) {
            // top
            dfs(0, column, canReachPacific, heights, heights[0][column]);
            // bottom
            dfs(ROWS - 1, column, canReachAtlantic, heights, heights[ROWS - 1][column]);
        }
        
        for (int row = 0; row < ROWS; row++) {
            // left edge
            dfs(row, 0, canReachPacific, heights, heights[row][0]);
            // right edge
            dfs(row, COLUMNS - 1, canReachAtlantic, heights, heights[row][COLUMNS - 1]);
        }



        // now collect results
        List<List<Integer>> results = new ArrayList<>();

        for (int row = 0; row < ROWS; row++) {
            for (int column = 0; column < COLUMNS; column++) {
                if (canReachPacific[row][column] && canReachAtlantic[row][column]) {
                    results.add(Arrays.asList(row, column));
                }
            }
        }




        return results;
    }


    private void dfs(int row, int column, boolean[][] canReach, int[][] heights, int previousHeight) {
        // Call Gaurd
        if (row < 0 || column < 0 || row >= heights.length || column >= heights[0].length || canReach[row][column] || heights[row][column] < previousHeight) {
            return;
        }

        // if we werent out of bounds, and if we didn't meet an already processed cell, and we can still flow up from here, 
        canReach[row][column] = true;

        for (int[] direction : DIRECTIONS) {
            dfs(row + direction[0], column + direction[1], canReach, heights, heights[row][column]);
        }

    }
}
