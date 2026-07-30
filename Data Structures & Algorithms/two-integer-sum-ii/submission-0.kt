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
