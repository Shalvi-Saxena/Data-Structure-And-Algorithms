/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean isLCA = false;

        while( !isLCA ) {
            if((p.val <= root.val && q.val >= root.val) || (p.val >= root.val && q.val <= root.val)) {
                return root;
            }else if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;
            }
        }
        return null;
    }
}