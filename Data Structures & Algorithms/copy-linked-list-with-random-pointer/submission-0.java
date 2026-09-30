/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // Standard edge case check
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node current = head;

        // Iterate through, copy the Nodes into the HashMap
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Now that we "cloned" them, we need to wire them up;
        current = head;
        while (current != null) {
            Node cloned = map.get(current);
            cloned.next = map.get(current.next);
            cloned.random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
