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
    TreeNode res;
    int index=0;
    public TreeNode inorder(TreeNode root, int k) {
        if(root == null) {
            return null;
        }
        TreeNode curr = inorder(root.left, k);
        if(index == k)  {
            return curr;
        }
        index++;
        if(index == k)  {
            return root;
        }
        
        return inorder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        index = 0;
        TreeNode curr = inorder(root, k);
        return curr.val;
    }
}