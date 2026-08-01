// TC: O(log n) since this is literally binary search which has a tc of log n
// SC: O(1) since we're not using any form of data structure
// Algorithm: It's binary search, check both halves, if it's too big, check left half... if it's too small, check right half. 


class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            var middle = (left + right) / 2
            when {
                nums[middle] == target -> return middle
                nums[middle] > target -> right = middle - 1
                else -> left = middle + 1
            }
        }
        return -1
    }
}
