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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;


        while (list1 != null && list2 != null) { 
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }

            // now move our tail forward
            tail = tail.next;

        }

        // now either list can still have leftovers...

        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }


        return dummy.next;


    }
}