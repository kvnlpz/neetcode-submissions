// TC: O(log(n)) binary search
// SC: O(1)
// Algorithm: start with an outer conditional that finds out which half of the array is "strictly sorted" so that we know the facts. A section that's not strictly sorted cannot gaurantee us the value that we want. if we check before hand then we can avoid the messed up parts and know where there the actual value is likely to be. The rest of the check is just binary search. It checks if the number is actually within the area we're checking and from there we do the standard binary search algo of adjusting our left and right and middle pointers until we can no longer do so


class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right) {
            var mid = left + (right - left) / 2

            if (nums[mid] == target) return mid
            
            // Check if the left half is strictly sorted first
            if (nums[left] <= nums[mid]) {
                // Is the target actually INSIDE this sorted inside this strictly sorted left half?
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1
                } else {
                    left = mid + 1
                }
            }

            // If the left half wasn't the strictly sorted half, then it HAS to be the right side
            else {
                // Is the target actually inside this strictly sorted right half?
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1 // narrow the search more
                } else {
                    right = mid - 1 // so it has to be on the left side otherwise
                }
            }
        }
        return -1
    }
}
