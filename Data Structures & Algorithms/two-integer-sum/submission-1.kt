// TC: O(n) because we're simply iterating through the integer array for this problem
// SC: O(n) because we are making use of a hashmap data structure that will contain the values given to us by the integer array and their indices

// Algorithm: iterate through the int array and calc the complement from the target value (target minus current = complement so then complement + value = target)
// And if we already have the complement value in the hashmap, then we can just return that, if we dont, we add what we found for the future
// When we find it, we just have to return an int array of the index of the complement and the current index
// complement index first because it wants the smaller index first, since the complement is in the map, it means we found it previously so that's the smaller index
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        
        for (i in nums.indices) {
            val current = nums[i]
            val complement = target - current
            
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, i)
            } else {
                map[current] = i
            }
        }
        
        return intArrayOf(0, 0)
    }
}