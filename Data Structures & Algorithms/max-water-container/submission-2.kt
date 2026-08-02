//TC: O(n) where n is the size of the array, we're simply looping through the array
//SC: O(1) because we're using 2 pointers, not actual data structure
//Algorithm:  we basically need to calculate the area for whenever we have two bars. We can use two pointers L&R and use the min of them because that's our limiting factor, we'll calc the area using the min heigh (L*W) and then, we'll move our pointers depending on which one is smaller, because since our smaller height is our limiting factor, it's more important for us to move that pointer in case we find a min height that's taller. We already have the bigger one, so it's not as important to move

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
