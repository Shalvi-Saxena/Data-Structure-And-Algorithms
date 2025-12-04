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

    private List<List<Integer>> getPaths(TreeNode root, int targetSum, 
    List<List<Integer>> paths, List<Integer> path) {
        if(root == null) {
            return paths;
        }
        path.add(root.val);
        targetSum -= root.val;

        if(root.left == null && root.right == null) {
            if(targetSum == 0) {
                paths.add(new ArrayList<>(path));
            }
        } else {
            getPaths(root.left, targetSum, paths, path);
            getPaths(root.right, targetSum, paths, path);
        }
        path.remove(path.size()-1);
        return paths;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        return getPaths(root, targetSum, paths, new ArrayList<>());
    }
}