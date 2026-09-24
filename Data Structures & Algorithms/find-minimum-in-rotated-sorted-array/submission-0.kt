// TC: O(Log(n)) just standard binary search 
// SC: O(1). no data structures
// Algorithm: iterate through the array and find when the inflection point. start the binary search algo using that point as the start and end 


// Notes: OG sorted in ascending order.
// Has now been rorated btween 1 and n times
// ex: [1,2,3,4,5,6] -> [3,4,5,6,1,2] if rotated 4 times
// another ex: [1,2,3,4,5,6] if rotated 6 times

// The problem says assuming all elements in the rotated sortd array `nums` are unique, return the min element of the Array



class Solution {
    fun findMin(nums: IntArray): Int {

        var left = 0
        var right = nums.lastIndex

        // USE STRICTLY LESS THAN SO THE LOOP STOPS WHEN LEFT == RIGHT
        while(left < right) {
            val mid = left + (right - left) / 2
            
            // Compare mid to the rightmost element to find the inflection point
            if (nums[mid] > nums[right]) {
                // Since the num at the mid isn't supposed to be bigger than right num in a sorted array, then this means it's shifted, so our smallest number is likely to the right side
                left = mid + 1
            }
            else right = mid
        }

        // since left and right will converge we can just return left
        return nums[left]
    }
}
