// TC: O(log(n + m))
// SC: O(1)
// Algorithm: TODO()

// Facts: 2 arrays, m, n, both sorted
// both lengths dfrnt

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // We MUST have the 1st array be the smaller array or else when we make cuts we might end up in an out of bounds exception
        if (nums1.size > nums2.size) {
            // So just recurse but with the arrays switched
            return findMedianSortedArrays(nums2, nums1)
        }
        // Store the array sizes for repeated use
        val m = nums1.size
        val n = nums2.size

        // Total length of both arrays combined
        val total = m + n
        
        val half = (total + 1) / 2
        
        // 2/3 pointers for our binary search
        var left = 0
        var right = m

        while (left <= right) {
            // the locations where we're going to be cutting
            val partitionA = (left + right) / 2
            val partitionB = half - partitionA

            // now that we have the partitions, we need to check the values
            val maxLeftA = nums1.getOrElse(partitionA - 1) { Int.MIN_VALUE }
            val minRightA = nums1.getOrElse(partitionA) { Int.MAX_VALUE }

            // we're grouping them here because that's how we're going to be comparing them

            val maxLeftB = nums2.getOrElse(partitionB - 1) { Int.MIN_VALUE }
            val minRightB = nums2.getOrElse(partitionB) { Int.MAX_VALUE }


            // if we found the perfect partition (basically, if all the values line up in the correct sorted order)
            if (maxLeftA <= minRightB && minRightA >= maxLeftB) {
                val maxLeft = maxOf(maxLeftA, maxLeftB)

                // Odd total length: median is just the max of the left side 
                if (total % 2 == 1) {
                    return maxLeft.toDouble()
                }

                // when it's an even total length: average the max left and min for the right
                val minRight = minOf(minRightA, minRightB)
                return (maxLeft + minRight) / 2.0

            } else if (maxLeftA > minRightB) { 
                // Partition A is too far right 
                right = partitionA - 1
            } else {
                // Partition A is too far left
                left = partitionA + 1
            }

        }

    throw IllegalArgumentException("Input arrays are not properly sorted.")

    }
}
