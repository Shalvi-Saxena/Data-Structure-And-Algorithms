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
    Deque<Long> list;
    public long DFS(TreeNode root) {
        if(root == null)    return 0;
        
        long sum = DFS(root.left) + DFS(root.right) + root.val;
        list.add(sum);
        return sum;
    }
    public int maxProduct(TreeNode root) {
        list = new ArrayDeque<>();
        long tSum = DFS(root); 
        long mod = 1000000007;
        long maxProd = 0;

        for(Long s1: list) {
            long s2 = tSum - s1;

            maxProd = Math.max(s1*s2, maxProd);
        }

        return (int)(maxProd % mod);
    }
}