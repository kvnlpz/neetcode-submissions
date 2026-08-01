// TC: O(log n) since this is literally binary search which has a tc of log n
// SC: O(1) since we're not using any form of data structure
// Algorithm: It's binary search, check both halves, if it's too big, check left half... if it's too small, check right half. 


class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            // Corrected: (right - left) prevents integer overflow and calculates the true midpoint
            var middle = left + (right - left) / 2 
            
            when {
                // if it's too big, we need to check the left side instead so make right be middle -1
                nums[middle] > target -> right = middle - 1
                // likewise if we're below the target amount we need to check the right side so make left be middle
                nums[middle] < target -> left = middle + 1
                // this means we found the target
                else -> return middle
            }
        }
        return -1
    }
}
