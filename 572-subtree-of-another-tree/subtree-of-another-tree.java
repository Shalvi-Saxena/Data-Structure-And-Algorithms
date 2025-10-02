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
    public TreeNode findNode(TreeNode root, TreeNode subRoot) {
        if(root == null || root.val == subRoot.val) {
            return root;
        }
        TreeNode leftNode = findNode(root.left, subRoot);
        if(leftNode != null && leftNode.val == subRoot.val) {
            return leftNode;
        }
        return findNode(root.right, subRoot);
    }

    public boolean checkSubTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }
        if((root == null && subRoot != null) || (root != null && subRoot == null) ||
           (root.val != subRoot.val)) {
            return false;
        }
        return checkSubTree(root.left, subRoot.left) &&
        checkSubTree(root.right, subRoot.right);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Stack<TreeNode> list = new Stack<>();
        list.push(root);
        while(!list.isEmpty()) {
            TreeNode node = list.pop();
            if(node.val == subRoot.val && checkSubTree(node, subRoot)) {
                return true;
            }
            if(node.left != null) {
                list.add(node.left);
            }

            if(node.right != null) {
                list.add(node.right);
            }
        }

        return false;
    }
}