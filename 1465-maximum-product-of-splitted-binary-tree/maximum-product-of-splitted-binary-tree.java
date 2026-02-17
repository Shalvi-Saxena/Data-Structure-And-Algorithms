class Solution {
    long maxProd = 0;
    final long MOD = 1_000_000_007L;

    private long totalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + totalSum(root.left) + totalSum(root.right);
    }

    private long computeMax(TreeNode root, long totalSum) {
        if (root == null) return 0;

        long left = computeMax(root.left, totalSum);
        long right = computeMax(root.right, totalSum);

        long subSum = root.val + left + right;
        long otherPart = totalSum - subSum;

        maxProd = Math.max(maxProd, subSum * otherPart);
        return subSum;
    }

    public int maxProduct(TreeNode root) {
        long total = totalSum(root);
        computeMax(root, total);
        return (int)(maxProd % MOD);
    }
}
