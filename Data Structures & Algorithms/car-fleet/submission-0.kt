// TC: O(nlogn) where n is the size of the longest input array. 
// SC: O(N) where N is the size of the input array because we're actually storing values in an array of pairs
// Algorithm: we're basically pairing the positions and speeds together to form an array of pairs. then we have to go thru the array and calculate how long each car will take to get to the target. we have to add that forecast to the stack. afterwards, we check the stack, if there's at least 2 in there, then we have two times to the target, so we can compare and see if the car before it is going to get there before or after it, if it's going to get there after it, then that means we have a fleet because our faster car wont be able to go around it, so we can just remove the faster one, the last one because if we leave it, and we compare another one to it later, we might think that since the last car is going fast we dont have a fleet, but if we remove it, we'd see the fleet that's limiting our speed.


class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        // List of pairs
        val cars = position.zip(speed).sortedByDescending { it.first } 
        val stack = kotlin.collections.ArrayDeque<Double>()
        
        for ((position, speed) in cars) {
            val timeToTarget = (target - position).toDouble() / speed // delta -> distance over time
            stack.addLast(timeToTarget)

            if (stack.size >= 2 && stack.last() <= stack[stack.lastIndex - 1]) {
                stack.removeLast()
            }

        }
        return stack.size
     }
}
