/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // Can't do any work if any of these are null, 
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // get to the halfway point of the linked list
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // now that we're at the middle, let's reverse the 2nd half

        ListNode currentNode = slow.next;
        slow.next = null; // so that we cut the list in half

        ListNode previousNode = null;

        while (currentNode != null) {
            ListNode temporaryNextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = temporaryNextNode;
        }

        // Now that it's reversed, we need to intertwine

        ListNode a = head;
        ListNode b = previousNode;

        while (b != null) {
            // backup the next nodes. 
            ListNode nextANode = a.next;
            ListNode nextBNode = b.next;

            a.next = b;
            b.next = nextANode;

            // now move the pointers forward
            a = nextANode;
            b = nextBNode;
        }



    }
}
