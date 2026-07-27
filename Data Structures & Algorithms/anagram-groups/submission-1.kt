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
