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
    public int inOrderBalanceCheck(TreeNode root) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null) {
            return 1;
        }
        
        int leftHeight = inOrderBalanceCheck(root.left);
        int rightHeight = inOrderBalanceCheck(root.right);

        if(leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1+Math.max(leftHeight, rightHeight);
    }
    public boolean isBalanced(TreeNode root) {
        return inOrderBalanceCheck(root) != -1;
    }
}