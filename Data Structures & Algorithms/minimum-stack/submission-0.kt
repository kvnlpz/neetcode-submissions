// TC: O(1) for all operations
// SC: O(n) where n is the size of the stack 
// Algorithm: we use two stacks, one stack that just stores the values but the other stack, the minStack, keeps track of only the smallest values first. so whenever we're pushing to the MinStack, we're actually pushing to both, the reg stack, and then we're finding out what the currentMin value is, either it's the number in the minstack or the current value we're given. either way, we add to the stack whatever the MINIMUM value is, either the currentMin or the new value. hence why we do minStack.add(minOf(currentMin, value))

class MinStack() {
    val stack = ArrayDeque<Int>()
    val minStack = ArrayDeque<Int>()

    fun push(value: Int) {
        stack.addLast(value)
        val currentMin = minStack.lastOrNull() ?: value
        minStack.add(minOf(currentMin, value))
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
       return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
