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
    public void rhs(TreeNode root, int level, List<Integer> view) {
        if(root == null)    return;
        if(view.size() == level) view.add(root.val);
        rhs(root.right, level+1, view);
        rhs(root.left, level+1, view);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if(root == null)    return view;
        rhs(root, 0, view);
        return view;
    }
}