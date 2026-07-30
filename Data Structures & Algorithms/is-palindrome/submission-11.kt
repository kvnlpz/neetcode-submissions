// TC: O(n) where n is the input string since we're just technically iterating through hit under the hood
// SC: O(1) because we didn't have to use any additional data structures for this
// Algorithm: We're going from the sides inwards while skipping over any non digits or letters and checking at each iteration if the letters match until we reach the middle

class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {

            // The following steps are for us to move passed the non letters / non digits
            // move to the right until we get to a non letter / digit
            while (left < right && !s[left].isLetterOrDigit()) left++
            // Do the same for the right pointer but the opposite direction
            while (left < right && !s[right].isLetterOrDigit()) right--

            // So if we check the current chars we're at and they're not the same, then we can return false, not a palindrome
            if(!s[left].equals(s[right], ignoreCase = true)) {
                return false
            }

            // Keep moving the left and right pointers towards each other
            left++
            right--
        }
        // if we get to the end, we can return true because we haven't failed yet! so palindrome
        return true

    }
}
