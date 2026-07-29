class Solution {
    // an array of character arrays (strings)
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()
        for (i in board.indices) {
            for (j in board[i].indices) {
                val current = board[i][j]
                if(current == '.') continue
                if (!set.add("$current at row $j") ||
                    !set.add("$current at col $i") ||
                    !set.add("$current at square ${i / 3} - ${j / 3}")) {
                    return false
                }

            }
        }
        return true
    }
}
