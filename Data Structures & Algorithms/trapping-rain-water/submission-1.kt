// TC: O(N) where n is the size of the input array
// SC: O(1) no data structures, just 2 pointers
// Algorithm: we store the heights of the left & right side and keep track of the tallest ones for both sides, at each iteration, if our left wall is shorter then we move more left, vice versa for the right wall. this is because we only care about which one is shorter, since that's our limiting factor. you can only store as much water as the shortest wall lets us. so depending on which one is shorter, we move more left or right, all the while, we keep track of the tallest left and right walls. Since we're doing this, we can calculate how much water we'd be storing based off how tall the shortest wall is, and comparing it to the depth of our current index, we dont care about the tallest wall because the shortest one is the limiting factor anyway. so we calculate it using maxLeftWall - height or maxRightWall - height, because the while loop already tells us that the maxLeft or maxRight wall is still shorter than the other maxWall. so we just accumulate it each time 

class Solution {
    fun trap(height: IntArray): Int {
        // We need two peaks to store water so if we have less than 3 bars of heights, no water can be stored
        if (height.size < 3) return 0

        var left = 0
        var right = height.lastIndex

        var maxLeftWall = height[left]
        var maxRightWall = height[right]

        var totalWater = 0
        while (left < right) {
            if (maxLeftWall < maxRightWall) {
                left++
                maxLeftWall = maxOf(maxLeftWall, height[left])
                totalWater += maxLeftWall - height[left]
            }
            else {
                right--
                maxRightWall = maxOf(maxRightWall, height[right])
                totalWater += maxRightWall - height[right]
            }
        }

        return totalWater
    }
}
