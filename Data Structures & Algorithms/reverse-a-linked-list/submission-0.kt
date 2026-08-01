// TC: O(n) doing a single pass
// SC: O(1) not using any other data structures
// Algorithm: We set a node called previous eq to null so that we can use it as a pointer to the previous node. We set a node called current to the head so that we can do modifications without affecting the input. iterate while the current node isnt null and for each iteration, make a temp node be eq to the node that the current node POINTS TO as its next node 
// that way, we back it up before modding the current one. now the current's next node can be set to the previous node, we're essentiallty rotating the relationship, instead of pointing to it's actual next node, it points 'backwards'
// then we can move the prev node forward, so now previous points to our CURRENT node, because we'll use it again next iteration
// then make the current node be the temp node (because we stored the actual next node in temp)
// this moves us forward
// finally when we stop iterating, we return the previous node at the end, because the previous node will still point to a non-null node, while CURRENT will point to a null node

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var previous: ListNode? = null
        var current = head

        while(current != null) {
            // back up our current one
            val temp = current.next
            // make the node that whe current one poitns to point to previous (reverse now)
            current.next = previous
            // make the node that keeps track of the previous one point to current (so when we move forward we still point to it, aka the previous node now)
            previous = current
            current = temp
        }
        //now we return previous because current would become null 
        return previous
    }
}
