// TC: O(n) where n is the input string since we're just technically iterating throug hit under the hood
// SC: O(n) where n is the input string because filter, lowercase, and reversed create new string objects under the hood
// Algorithm: We're opting for idiomatic kotlin approaches 
class Solution {
    fun isPalindrome(s: String): Boolean {
        val cleaned = s.filter { it.isLetterOrDigit() }.lowercase()
        return cleaned == cleaned.reversed()

    }
}
