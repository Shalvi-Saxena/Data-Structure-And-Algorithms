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
    List<int[]> list = new ArrayList<>();
    private void dfs(TreeNode root, int row, int col) {
        if(root == null)    return;
        list.add(new int[]{col, row, root.val});
        dfs(root.left, row+1, col-1);
        dfs(root.right, row+1, col+1); 
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)    return res;
       
        dfs(root, 0, 0);
        Collections.sort(list, (a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return Integer.compare(a[2], b[2]);
                }
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int prevCol = Integer.MIN_VALUE;
        int ind = -1;
       
        for(int[] i: list) {
            if(i[0] != prevCol) {
                prevCol = i[0];
                ind++;
                res.add(new ArrayList<>());
            }
            res.get(ind).add(i[2]);
        }

        return res;
    }
}