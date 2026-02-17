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
    long max = 0;
    public long DFS(TreeNode root) {
        if(root == null)    return 0;
        return DFS(root.left) + DFS(root.right) + root.val;
    }

    public long findMax(TreeNode root, long tSum) {
        if(root == null)    return 0;

        long sum = findMax(root.left, tSum) + findMax(root.right, tSum) + root.val;
        long diff = tSum-sum;
        max = Math.max(max, diff*sum);

        return sum;
    }

    public int maxProduct(TreeNode root) {
        long tSum = DFS(root); 
        long mod = 1000000007;
        long maxProd = findMax(root, tSum);

        return (int)(max % mod);
    }
}