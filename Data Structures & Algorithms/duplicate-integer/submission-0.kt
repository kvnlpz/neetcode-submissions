class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        var seen = mutableSetOf<Int>()
        for(num in nums) {
            if(!seen.add(num)) {
                return true
            }
        }
        return false
    }
}
