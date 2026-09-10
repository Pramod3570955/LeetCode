class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // Maximum path passing through current node
        int currentPath = left + root.val + right;

        maxSum = Math.max(maxSum, currentPath);

        // Return only ONE branch to parent
        return root.val + Math.max(left, right);
    }
}