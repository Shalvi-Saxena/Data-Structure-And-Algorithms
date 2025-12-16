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
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> level = new LinkedList<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();

        level.add(root);
        map.put(root, 1);

        int max = level.size(), start=0, end=0;
        
        while(!level.isEmpty()) {
            
            Queue<TreeNode> nextLevel = new LinkedList<>();
            int size=level.size();
            
            for(int i=0; i<size; i++) {
                TreeNode node = level.poll();
                if(i==0) {
                    start = map.get(node);
                }
                if(i==size-1) {
                    end = map.get(node);
                }

                if(node.left != null) {
                    nextLevel.add(node.left);
                    map.put(node.left, map.get(node)*2);
                }
                if(node.right != null) {
                    nextLevel.add(node.right);
                    map.put(node.right, map.get(node)*2 + 1);
                } 
            }
            
            level = nextLevel;
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}