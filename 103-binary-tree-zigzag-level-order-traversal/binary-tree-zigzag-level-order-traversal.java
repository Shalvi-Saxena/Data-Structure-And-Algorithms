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
    public List<Integer> getLevelVal(List<TreeNode> level, boolean flag) {
        List<Integer> list = new ArrayList<>();
        if(flag) {
            for(int i=0; i<level.size(); i++) 
                list.add(level.get(i).val);
        } else {
            for(int i=level.size()-1; i>=0; i--) 
                list.add(level.get(i).val);
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> seq = new ArrayList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        boolean flag = true;

        while(!level.isEmpty()) {
            seq.add(getLevelVal(level, flag));
            List<TreeNode> newLevel = new ArrayList<>();
            for(int i=0; i<level.size(); i++) {
                if(level.get(i).left != null) {
                    newLevel.add(level.get(i).left);
                }
                if(level.get(i).right != null) {
                    newLevel.add(level.get(i).right);
                }
            }
            level = newLevel;
            flag = !flag;
        }

        return seq;
    }
}