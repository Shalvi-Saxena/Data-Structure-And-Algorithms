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
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);

        while(!q.isEmpty()) {
            int sum = 0, s = q.size();
            level++;
            while(s-- > 0) {
                TreeNode n = q.poll();
                sum += n.val;
                if(n.left != null)  q.add(n.left);
                if(n.right != null)  q.add(n.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                minLevel = level;
            }
        }

        return minLevel;
    }
}