// TC: O(n) where n is the size of the array because we're using 2 pointers and at worse case it just loops through the entire array
// SC: O(1) no data structures were used

// Algorithm: Use 2 pointers which start from left most and also from right most
// at each iteration we're calculating the sum of the numbers at the pointers so that we can see if we're where we want
// if the number is too big though, we move the right pointer more to the left becaue it will get us to a shorter value
// since the array is already sorted for us... but if the sum is too small, we move the left pointer more right, because 
// the right pointer is already at the biggest value it can have, so the next logical step is to move the left pointer more 
// right as the values grow bigger.


class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var left = 0
        var right = numbers.lastIndex // same as numbers.size - 1

        while (left < right) {
            val sum = numbers[left] + numbers[right]
            when {
                sum == target -> return intArrayOf(left+1, right+1) // adding +1 because it's 1-indexed for output
                sum > target -> right--
                else -> left++
            }
        }
        return intArrayOf()
    }
}
