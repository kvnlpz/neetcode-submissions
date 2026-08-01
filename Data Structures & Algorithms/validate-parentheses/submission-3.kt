// TC: O(N) where N is the size of the string 
// SC: O(N) where n is the size of the string (worst case, we fill the stack up)
// Algorithm: as we're iterating through the string, we add the chars that we find to the stack, whenever we find a matching closing bracket, we pop the stack so that we can remove that pair entirely, and when we find an opening bracket, we add it to the stack again. In the end, if we end up with an empty stack, it means each opening bracket had a matching closing bracket. if it is not empty, then it didn't have all matching ones and we have to return false


import kotlin.collections.ArrayDeque
class Solution {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()
        val pairs = mapOf(']' to '[', ')' to '(', '}' to '{')
        for (char in s) {
            if (pairs.containsKey(char)) {
                if (stack.removeLastOrNull() != pairs[char]) {
                    return false
                }
            }
            else {
                stack.addLast(char)
            }
        }
        return stack.isEmpty()
    }
}
