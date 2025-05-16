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
    public int getIndex(int[] inorder, int val, int start, int end) {
        for(int i=start; i<=end; i++) {
            if(val == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder,int start, int end) {
        // System.out.println("start = "+start+" end = "+end+" index = "+index);
        if(start>end || index<0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index--]);
        int newIndex = getIndex(inorder, root.val, start, end);
        root.right = buildTree(inorder, postorder, newIndex+1, end);
        root.left = buildTree(inorder, postorder, start, newIndex-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length-1;
        return buildTree(inorder, postorder, 0, index);
    }
}