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
    private Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    private int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildSubTree(preorder, 0, inorder.length);
    }

    private TreeNode buildSubTree(int[] preorder, int start, int end) {
        if (start >= end) {
            return null;
        }

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int inorderIndex = inorderIndexMap.get(rootVal);
        root.left = buildSubTree(preorder, start, inorderIndex);
        root.right = buildSubTree(preorder, inorderIndex + 1, end);

        return root;
    }
}
