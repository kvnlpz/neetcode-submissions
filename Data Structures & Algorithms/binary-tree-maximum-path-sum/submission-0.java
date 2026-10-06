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

    private int globalMaxSum;


    public int maxPathSum(TreeNode root) {
        globalMaxSum = Integer.MIN_VALUE;
        calculateMax(root);
        return globalMaxSum;
    }

    private int calculateMax(TreeNode node) {
        if (node == null) return 0;
        
        // if it gets less then we dont need it tainting our results so set to 0
        int maxLeft = Math.max(calculateMax(node.left), 0);
        int maxRight = Math.max(calculateMax(node.right), 0);

        int currentPathSum = maxLeft + node.val + maxRight;

        globalMaxSum = Math.max(globalMaxSum, currentPathSum);

        return node.val + Math.max(maxLeft, maxRight);
    }
}
