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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return pathSumFromNode(root, (long)sum)
             + pathSum(root.left, sum)
             + pathSum(root.right, sum);
    }

    public int pathSumFromNode(TreeNode root, long sum) {
        if (root == null) return 0;

        int count = (root.val == sum) ? 1 : 0;

        count += pathSumFromNode(root.left, sum - root.val);
        count += pathSumFromNode(root.right, sum - root.val);

        return count;
    }
}
