class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int rows = board.length;
        int columns = board[0].length;

        for (int row = 0; row < rows; row++) {
            dfs(board, row, 0, rows, columns);
            dfs(board, row, columns - 1, rows, columns);
        }


        for (int column = 0; column < columns; column++) {
            dfs(board, 0, column, rows, columns);
            dfs(board, rows - 1, column, rows, columns);
        }


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'O') {
                    board[row][column] = 'X';
                }
                else if (board[row][column] == 'S') {
                    board[row][column] = 'O';
                }
            }
        }
        
    }


    private void dfs(char[][] board, int row, int column, int rows, int columns) {
        if (row < 0 || column < 0 || row >= rows || column >= columns || board[row][column] != 'O') {
            return;
        }

        board[row][column] = 'S';

        dfs(board, row+1, column, rows, columns);
        dfs(board, row-1, column, rows, columns);
        dfs(board, row, column+1, rows, columns);
        dfs(board, row, column-1, rows, columns);
    }
}
