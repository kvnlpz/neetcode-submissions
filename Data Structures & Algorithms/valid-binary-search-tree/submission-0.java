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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValid(TreeNode node, int maxBound, int minBound) {
        if (node == null) return true;
        if (node.val <= minBound || node.val >= maxBound) {
            return false;
        }
        return isValid(node.left, node.val, minBound) && isValid(node.right, maxBound, node.val);
    }
}
