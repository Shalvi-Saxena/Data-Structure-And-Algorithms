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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();

        if(root == null) {
            return res;
        }

        level.add(root);

        while(!level.isEmpty()) {
            List<TreeNode> tempLevel = new ArrayList<>();
            List<Integer> tempRes = new ArrayList<>();
            while(!level.isEmpty()) {
                TreeNode head = level.remove(0);
                tempRes.add(head.val);
                if(head.left != null) {
                    tempLevel.add(head.left);
                }
                if(head.right != null) {
                    tempLevel.add(head.right);
                }
            }
            level = tempLevel;
            res.add(tempRes);  
        }

        return res;
    }
}