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

    public List<String> binaryTreePathsNew(TreeNode root, String path, List<String> res) {
        if(root == null) {
            return res;
        }
        path = path+"->"+root.val;
        if(root.left == null && root.right == null) {
            res.add(path);
            return res;
        }
        res = binaryTreePathsNew(root.left, path, res);
        res = binaryTreePathsNew(root.right, path, res);
        return res;
    }

    public List<String> binaryTreePaths(TreeNode root) {
        String path = root.val+"";
        List<String> res = new ArrayList<String>();
        res = binaryTreePathsNew(root.left, path, res);
        res = binaryTreePathsNew(root.right, path, res);
        if(res.size() == 0) res.add(path);
        return res;
    }
}