// TC: Since we're going through each string that's already O(N) right there depending on how many strings we get 
// But additionally, for every string we have, we're also going to be going through the individual characters so that 
// Would make it O(N*M) (lowercase) 

// SC: Since we're using a map for the groups, we store the values for N strings, and each string has characters that we make use of too, so for every string, we use will take up space, M, so 
// it will be O(N*M)

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String,  MutableList<String>>()

        for(string in strs) {
            val alphabet = IntArray(26)
            for(character in string) {
                alphabet[character - 'a']++
            }
            val key = alphabet.joinToString("#")
            map.putIfAbsent(key, mutableListOf())
            map[key]!!.add(string)
        }

        return map.values.toList()
    }
}
