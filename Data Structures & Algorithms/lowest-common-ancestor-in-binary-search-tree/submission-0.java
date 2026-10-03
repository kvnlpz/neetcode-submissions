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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode currentNode = root;
        while (currentNode != null) {
            if (p.val > currentNode.val && q.val > currentNode.val) {
                currentNode = currentNode.right;
            }

            if (p.val < currentNode.val && q.val < currentNode.val) {
                currentNode = currentNode.left;
            }

            else return currentNode;
        }

        return null;
    }
}
