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
    int maxSum;

    public int postOrder(TreeNode root) {
        if(root == null)    return 0;
        
        int left = Math.max(0, postOrder(root.left));
        int right = Math.max(0, postOrder(root.right));

        maxSum = Math.max(maxSum, left+right+root.val);
        
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        postOrder(root);

        return maxSum;
    }
}