// TC: O(log(m * n)) m is number of rows and n is numberof colums
// SC: O(1) we're not using any data structures
// Algorithm: we're just doing regular binary search but instead of altering the algorithm for the matrix, we're slightly modifying the way we calculate the middle so that it converts to a 2d array compatible variable.  instead of the middle value just being in between the left and right pointer, we have to determine where it would be in the 2d array. Because usually it's a 1d array, we have to calculate the 2d array version. So we divide the middle value by the amount of columns we have to determine which row we end up at, and then we do middle % columns to determine which colum we'll actually end up on. everything else remains the same in regards to the binary search  algorithm 

class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // Dont do any work if we dont have to
        if (matrix.isEmpty() || matrix[0].isEmpty()) return false
        
        val columns = matrix[0].size
        var left = 0
        var right = (matrix.size * columns) - 1

        while (left <= right) {
            var middle = left + (right - left) / 2

            // use / to see where we land in the matrix 
            // use modulus to keep the index within the matrix
            val middleValue  = matrix[middle / columns][middle % columns]

            when {
                middleValue == target -> return true
                middleValue < target -> left = middle + 1 
                else -> right = middle - 1
            }


        }

        return false
    }
}
