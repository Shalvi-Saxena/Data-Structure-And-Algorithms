class Solution {
    List<TreeNode> result = new ArrayList<>();
    Set<Integer> toDeleteSet;

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }

        root = dfs(root);

        if (root != null) {
            result.add(root);
        }

        return result;
    }

    private TreeNode dfs(TreeNode node) {
        if (node == null) return null;

        node.left = dfs(node.left);
        node.right = dfs(node.right);

        if (toDeleteSet.contains(node.val)) {
            if (node.left != null) result.add(node.left);
            if (node.right != null) result.add(node.right);
            return null; // delete this node
        }

        return node;
    }
}