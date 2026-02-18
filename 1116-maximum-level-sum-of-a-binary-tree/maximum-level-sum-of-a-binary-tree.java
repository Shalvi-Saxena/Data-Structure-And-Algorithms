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
    public int maxLevelSum(TreeNode root) {
        if(root == null)    return 0;

        int maxSum = Integer.MIN_VALUE, minLevel = 0, level = 0;
        List<TreeNode> q = new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int sum = 0;
            level++;
            List<TreeNode> nextQ = new ArrayList<>();
            for(TreeNode n: q) {
                sum += n.val;
                if(n.left != null)  nextQ.add(n.left);
                if(n.right != null)  nextQ.add(n.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                minLevel = level;
            }
            q = nextQ;
        }

        return minLevel;
    }
}