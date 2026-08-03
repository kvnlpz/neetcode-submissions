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
