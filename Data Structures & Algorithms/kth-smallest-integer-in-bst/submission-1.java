/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            // Remember, you're still in the outer while loop
            // Process the current node 
            current = stack.pop();
            k--;

            if (k == 0) return current.val;

            current = current.right;
        }

        throw new IllegalArgumentException("K is larger than the size of the tree");
    }
}
