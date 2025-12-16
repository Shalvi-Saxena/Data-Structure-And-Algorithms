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
        Queue<Pair> level = new LinkedList<>();
        level.add(new Pair(root, 0));
        int max = 0, start=0, end=0;
        
        while(!level.isEmpty()) {
            int size=level.size();
            for(int i=0; i<size; i++) {
                Pair item = level.poll();
                TreeNode node = item.node;
                Integer ind = item.ind;

                if(i==0) {
                    start = ind;
                }
                if(i==size-1) {
                    end = ind;
                }

                if(node.left != null) {
                    level.add(new Pair(node.left, ind*2));
                }
                if(node.right != null) {
                    level.add(new Pair(node.right, ind*2 + 1));
                } 
            }
            
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    class Pair {
        TreeNode node;
        Integer ind;

        Pair(TreeNode node, Integer ind) {
            this.node = node;
            this.ind = ind;
        }
    }
}