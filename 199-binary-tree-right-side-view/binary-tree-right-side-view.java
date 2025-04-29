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
    // public void postOrderTraversal(TreeNode root, int level, List<Integer> view) {
    //     if(root == null)    return;
    //     if(view.size() < level) {}
    // }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if(root == null)    return view;
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while(!level.isEmpty()) {
            view.add(level.get(level.size()-1).val);
            List<TreeNode> nextLevel = new ArrayList<>();
            for(TreeNode curr: level) {
                if(curr.left != null) {
                    nextLevel.add(curr.left);
                }
                if(curr.right != null) {
                    nextLevel.add(curr.right);
                }
            }
            level = nextLevel;
        }

        return view;
    }
}