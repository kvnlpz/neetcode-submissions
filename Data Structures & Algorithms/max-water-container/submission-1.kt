class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.lastIndex
        var maxWater = 0
        while (left < right) {
            var height = minOf(heights[left], heights[right])
            var width = right - left
            maxWater = max(maxWater, width * height)
            when {
                heights[left] <= heights[right] -> left++
                else -> right--
            }
        }
        return maxWater
    }
}
