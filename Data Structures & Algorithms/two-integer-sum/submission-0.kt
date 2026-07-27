class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        
        for (i in nums.indices) {
            val current = nums[i]
            val complement = target - current
            
            if (map.containsKey(complement)) {
                if(i < map[complement]!!) return intArrayOf(i, map[complement]!!)
                else return intArrayOf(map[complement]!!, i)
            } else {
                map[current] = i
            }
        }
        
        return intArrayOf(0, 0)
    }
}