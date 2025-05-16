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
    int index;
    HashMap<Integer, Integer> inIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder,int start, int end) {
        if(start>end || index<0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index--]);
        int newIndex = inIndex.get(root.val);
        root.right = buildTree(inorder, postorder, newIndex+1, end);
        root.left = buildTree(inorder, postorder, start, newIndex-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        inIndex = new HashMap<>();
        for(int i=0; i<inorder.length; i++) {
            inIndex.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, index);
    }
}