// TC: O(log(n)) for the get command and O(1) for the set command
// SC: O(m*n) where n is the total num of vals associated with a key and m is the total num of keys
// Algorithm: basically, we just add a list of TimeData objects to the map every time we add to it, that's all there is to that aspect, but when we get it, we have to do a modified version of binary search. Since we dont care about the lower half (because we want the highest previous timestamp value) we can completely ignore the left side of the array each time. As binary saerch iterates, it will get closer and closer to the Previous timestamp, which will let us return the next closest one

// Facts: set() -> store key with val at timestamp
// get() -> return value where previous timestamp <= timestamp
// if there are multiple such values -> return largest previous timestamp
// if no vals return "" 




class TimeMap() {
    private data class TimeData(val value: String, val timestamp: Int)
    private val keyStore = HashMap<String, MutableList<TimeData>>()


    fun set(key: String, value: String, timestamp: Int) {
        keyStore.getOrPut(key) { mutableListOf() }.add(TimeData(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        // if we dont even have the key then just return "" before even doing any work
        val values = keyStore[key] ?: return ""

        var left = 0
        var right = values.lastIndex
        var res = ""
        while (left <= right) {
            val mid = left + (right - left) / 2

            if (values[mid].timestamp <= timestamp) {
                res = values[mid].value
                left = mid + 1
            } else {
                right = mid - 1
            }

        }
        return res
    }
}
