// TC: O(N^2) it would be n*m if it were a rectangle but it's a square, so we do n x n work which becomes n^2 
// SC: O(N^2) as well because N is the length of the board and since we're storing each value we find, at worse case scenario
// it could be O(N^2), using every char found in the entire board.
// Algorithm: We go through each row and column and add the value (as long as it's not a .) to the set. 
// Since we have their positions, we can just say something like 4 is at column 2, so that eventually if we find another 
// 4 at column 2, we immediately return false
// we do a similar thing for the squares, except we just divide the position by 3 because it's a SQUARE with 9 subsquares in it

class Solution {
    // an array of character arrays (strings)
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()
        for (i in board.indices) {
            for (j in board[i].indices) {
                val current = board[i][j]
                if(current == '.') continue
                if (!set.add("$current @r $j") ||
                    !set.add("$current @c $i") ||
                    !set.add("$current @s ${i/3} - ${j/3}")) {
                    return false
                }

            }
        }
        return true
    }
}
