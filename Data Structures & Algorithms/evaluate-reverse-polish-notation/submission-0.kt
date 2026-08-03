// TC: O(n) where n is the size of the input array
// SC: O(n) where n is the size of the input array (at worse, we'll have to store all the values)
// Algorithm: We will go thru the input tokens and check what they have, if it's any nondigit, we consider it an operator so we have to get the last 2 items in the stack to do the operation on them, so that's why we have a stack, because it keeps track of the values we need to operate on. If we dont find an operator, then it's an integer that we need to store, so that's when we store it in the stack. at the end, just return the last item in the stack.

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        for(token in tokens) {
            when (token) {
                "+" -> {
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.addLast(b + a)
                }
                "-" -> {
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.addLast(b - a)
                }
                "/" -> {
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.addLast(b / a)
                }
                "*" -> {
                    val a = stack.removeLast()
                    val b = stack.removeLast()
                    stack.addLast(b*a)
                }
                else -> stack.addLast(token.toInt())
            }
        }
    return stack.removeLast()
    }
}
