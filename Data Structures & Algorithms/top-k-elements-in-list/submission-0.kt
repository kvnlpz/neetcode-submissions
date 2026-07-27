class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // create buckets that we're going to store each num in
        val buckets = Array<MutableList<Int>?>(nums.size + 1) { null }
        // create the map that will help us 
        val frequencyMap = HashMap<Int, Int>()

        // populate the freq map with values first
        for (n in nums) {
            frequencyMap[n] = frequencyMap.getOrDefault(n, 0) + 1
        }

        //Step 3 group nums by freq
        for ((key, frequency) in frequencyMap) {
            if ( buckets[frequency] == null ) {
                buckets[frequency] = ArrayList()
            }
            // Add the number (key) into the bucket corresponding to its frequency
            // The `!!` tells Kotlin we are certain the list isn't null here
            buckets[frequency]!!.add(key)
        }

        // Step 4: gather the top K most frequent elements
        val output = IntArray(k)
        var index = 0
        // iterate thru the bucket array backwards 

        for ( i in buckets.size - 1 downTo 0) {
            val bucket = buckets[i]

            // if the bucket at this freq isn't empty, process its nums
            if (bucket != null) {
                // add the num to our final output array
                for (number in bucket) {
                    output[index++] = number
                }
                if (index == k) return output
            }
        }
        return output
    
    }
}
