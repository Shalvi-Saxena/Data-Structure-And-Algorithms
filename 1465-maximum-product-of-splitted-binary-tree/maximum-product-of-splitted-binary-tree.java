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
    List<Long> list;
    public long DFS(TreeNode root, int currSum) {
        if(root == null)    return 0;
        
        long lSum = root.left != null? DFS(root.left, currSum): 0;
        long rSum = root.right != null? DFS(root.right, currSum): 0;

        list.add(lSum+rSum+root.val);
        return lSum+rSum+root.val;
    }
    public int maxProduct(TreeNode root) {
        list = new ArrayList<>();
        long tSum = DFS(root, 0); 
        long mod = 1000000007;
        long maxProd = 0;

        for(Long s1: list) {
            long s2 = tSum - s1;

            maxProd = Math.max(s1*s2, maxProd);
        }

        return (int)(maxProd % mod);
    }
}