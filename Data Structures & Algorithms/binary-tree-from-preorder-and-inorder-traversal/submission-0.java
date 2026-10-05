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

    private int preorderIndex = 0;

    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            // We're storing the item in the map and giving it a value as the index
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd) return null;

        int rootVal = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootVal);


        int rootIndex = inorderIndexMap.get(rootVal);

        root.left = buildTreeHelper(preorder, inorderStart, rootIndex - 1);
        root.right = buildTreeHelper(preorder, rootIndex + 1, inorderEnd);

        return root;
    }   
}
