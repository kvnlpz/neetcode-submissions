// TC: O(N) where N is the size of the input heights array - we're iterating through it
// SC: O(N) where N is the size of the stack, at worst case, we fill it up with every value in the input array
// Algorithm: We use a maxArea variable to keep track of the largest amount of area that we've made thus far. and we use a stack to keep track of the tallest heights. We start off by iterating from 0 to the end of the array. at every iteration we do a few things, first we set the current height. if it's at the last index, we manually set it to 0 to force it to use an imaginary wall of that height. if it's any other index, we use the actual value for the height at that index. this is because if we get to the end we still need to have a wall. At any rate, for each iteration, we check if the stack is empty, and if it isn't we keep going while it's not empty and while the last item in the stack is taller than our current height. this is because our limiting factor is the current height. if it's taller then we need to get rid of it anyway because the shorter height is the one that matters. so we remove it and use it to calc the area using that height and the width. for the width, we either use i or the difference from i to the index of the height we just removed, because if the stack is empty then the width is just, i, that's the difference. but if we still haeve elements in the stack we have to calc the difference in positions from our current position to that position. so we just set the height to that outcome and calculate the maxArea using maxOf(). at the end of every iteration we add the current height to the stack because we have to keep checking, at the end, just return the maxArea



class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val stack = ArrayDeque<Int>()


        for (i in 0 .. heights.size) {
            // this is for an edge case of if the heigts are always increasing. if that happens, we'd get to the end without ever triggering the while loop. So we can set the currentHeight to 0, it's basically a fake wall that forces the rest of the walls to get resolved
            val currentHeight = if (i == heights.size) 0 else heights[i]

            // So when we go through the while loop, we're getting rid of every height that's taller than the current height because the current height is the limiting factor. 
            while (stack.isNotEmpty() && heights[stack.last()] > currentHeight) {
                // removing the item and using it to get the height
                val height = heights[stack.removeLast()] 
                // calculating the width by either using the index if the stack is now empty or getting the difference between the current index and the last element in the stack. 
                // think of it like trying to install a rug and you still have furniture in the room, if the stack is not empty then you measure the gap between you and the furniture
                // if it is empty then you just use your position
                val width = if (stack.isEmpty()) i else i - stack.last() - 1

                // Now we literally just calculate the area and try to make it the maximum value thus far
                maxArea = maxOf(maxArea, height * width)
            }

            // as we're moving forward we have to add the current index to the stack
            stack.addLast(i)
        }

        return maxArea
    }
}
