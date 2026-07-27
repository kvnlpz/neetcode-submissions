class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        val alphabet = IntArray(26)
        for (i in s.indices) {
            alphabet[s[i] - 'a']++
            alphabet[t[i] - 'a']--
        }
        for (count in alphabet) {
            if (count != 0) return false
        }
        return true
    }
}