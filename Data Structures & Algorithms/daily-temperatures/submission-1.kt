// TC: O(N) since we're iterating through the entire array
// SC: O(N) at worst case we store all the values in the stack, and we do have a results array
// Algorithm: we basically loop through the entire array and use a stack to keep track of every temp that we havent beaten yet. so while we go thru it, we store the current temp of the day and we compare it to the top item in the stack, if the top item in the stack is not higher temp than the current temp then we just add the current temp to the stack too (or if the stack is empty)
// Then when we DO find a prev temp that's lower than the temp of the day, then we pop it and mark the difference in days in the corresponding index in the array, and the beauty is that with the while loop, if we keep finding the same thing in which the previous day is less hot then we can pop and remove them from the stack and update their array index too

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // Will store results here obv
        val result = IntArray(temperatures.size)
        // We'll use a stack to keep track of the amount of time between temps
        val stack = ArrayDeque<Int>()

        // Loop through the temperatures
        for (i in temperatures.indices) {
            // Store the temperature on the current day
            val temperatureToday = temperatures[i]

            // Now go through the stack, as long as it's not empty, on the first iteration, it will be empty so we just add the index to the stack
            // if it's not empty, then we'll also check if the temp on the current day is higher than the temperature of the last day that is stored in the stack, 

            while (stack.isNotEmpty() && temperatureToday > temperatures[stack.last()]) {
                // if it is, then we can actually remove that last date from the stack, because we just increased in temp
                val pastDayIndex = stack.removeLast()
                // so now we can actually fill in the index for that date with the amount of days that went by before the temp went up again
                result[pastDayIndex] = i - pastDayIndex
            }

            // if it was our first time, or if we just didn't find a temp that is smaller then we keep adding to the stack
            stack.addLast(i)

        }
        return result
    }
}
