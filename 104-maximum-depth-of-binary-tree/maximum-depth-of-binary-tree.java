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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ArrayList<TreeNode> treeLevel = new ArrayList<TreeNode>();
        treeLevel.add(root);
        int level = 0;

        while(!treeLevel.isEmpty()) {
            level++;
            ArrayList<TreeNode> tempLevel = new ArrayList<TreeNode>();
            while(!treeLevel.isEmpty()) {
                TreeNode temp = treeLevel.remove(0);
                if(temp.left != null) {
                    tempLevel.add(temp.left);
                }
                if(temp.right != null) {
                    tempLevel.add(temp.right);
                }
                
            }
            treeLevel = tempLevel;
        }
        return level;
    }
}