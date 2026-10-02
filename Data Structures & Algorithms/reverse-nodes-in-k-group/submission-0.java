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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        // Keep track of the groups
        ListNode dummy = new ListNode(0, head);
        ListNode nodeBeforeGroup = dummy;

        while (true) {
            // Find the end of the group
            ListNode groupEnd = findKthNode(nodeBeforeGroup, k);
            if (groupEnd == null) {
                break; // not enough nodes to reverse
            }
            
            ListNode groupStart = nodeBeforeGroup.next;
            ListNode nextGroupStart = groupEnd.next;

            // Disconnect the group that we're reversing
            groupEnd.next = null;
            // reverse from the start of the group to the end of the group
            reverseLinkedList(groupStart);
            
            // Now that it's reversed, we need to reconnect everything
            // move our pointer to the start of the next group
            nodeBeforeGroup.next = groupEnd;
            // Since the group start is not the group end because of the reversal, make its next node point to the next group start
            groupStart.next = nextGroupStart;
            
            // Remember, now groupStart is groupEnd
            nodeBeforeGroup = groupStart;
            
        }
        return dummy.next;
    }


    private ListNode findKthNode(ListNode current, int k) {
        while (current != null && k > 0) {
            current = current.next;
            k--;
        }
        return current;
    }


    private void reverseLinkedList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode backupOfNextNode = current.next;
            current.next = previous;
            previous = current;
            current = backupOfNextNode;
        }
    }
}
