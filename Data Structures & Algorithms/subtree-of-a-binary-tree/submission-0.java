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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }
        // Call isSubTree for the subroot but for other parts of our tree, like left and right subnodes
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }



    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;

        if (root != null && subRoot != null && root.val == subRoot.val) {
            // use && because everything BELOW has to be the same, otherwise it's not a subtree
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
        return false;
    }
}
