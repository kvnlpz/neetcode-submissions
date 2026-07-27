// TC: O(N) sine we have ti iterate through the nums array to get the values, we iterate thru the frequency map too but it's still N
// SC:  O(N) since we have data structures that depend on the size of the actual input array numbers
// Algorithm: We create a buckets array that stores the numbers that belong together for their respective freqs
// we use a frequency map to actually calculate the frequencies for each number
// first we have to iterate thru the nums array and populate the freq map 
// once we populated the frequency map (the key is the number and the value is the amount of times we found that number)
// we have to then iterate through the freqmap and while we're doing that, we get the actual frequency for each number
// so that we can get the actual numbers that go into the right frequency bucket. for example, if we have two 1's and two 2's and one 3, those
// 1s and 2s will go into the same bucket
// so we get the frequency from the key in the freqmap, and we go to the array and put the key into the freq index

// finally we have to get the top k of them so we go through the buckets array backwards and whenever there's an actual bucket with values, we go through 
// the numbers and add them to the output array. think of it this way, if we have a bucket that has 3, and 2, it means those showed up for the same amount 
// of times, so we add those values to the output array, if we meet the amount of nums we need we just return the output

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
