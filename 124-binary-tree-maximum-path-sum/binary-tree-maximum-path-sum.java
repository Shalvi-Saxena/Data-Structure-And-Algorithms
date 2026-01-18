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
    HashMap<TreeNode, Integer> map;

    public void postOrder(TreeNode root) {
        if(root == null)    return;
        postOrder(root.left);
        postOrder(root.right);

        int max = Math.max(map.get(root.left), map.get(root.right));
        map.put(root, Math.max(max+root.val, root.val));

        max = Math.max(max, map.get(root.left)+map.get(root.right))+root.val;
        max = Math.max(max, root.val);
        
        maxSum = Math.max(max, maxSum);
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        map = new HashMap<>();
        map.put(null, 0);
        postOrder(root);

        return maxSum;
    }
}