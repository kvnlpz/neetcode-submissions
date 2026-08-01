// TC: O(N) where n is the size of the prices array becasue we're iterating through the array from start to end
// SC: O(1) since we're not even using any data structures to keep track of anything
// Algorithm: Iterate through the array and keep track of the lowest value we find, every time we find a lower value we 
// change the current lowest price value, at the same time we're also checking if the value is even smaller or not
// because if it's not smaller, then it's either the same, or bigger. This lets us know that we have a potential for profit so instead, we do the calculation, max profit will be either the same, or the value of minPrice - price, indicating how much we would make by selling

class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (price in prices) {
            // We found a new lowest price to buy at
            if (price < minPrice) {
                minPrice = price
            }

            // If it's not lower than the min price it means it's either the same
            // or bigger so we have a profit potential so can calc the value here
            else {
                maxProfit = maxOf(maxProfit, price - minPrice)
            }
        }
        return maxProfit
    }
}
