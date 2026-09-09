class Solution {

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return 0;
        }

        return countFrom(root, targetSum)
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }

    private int countFrom(TreeNode node, long target) {

        if (node == null) {
            return 0;
        }

        long remaining = target - node.val;

        int count = 0;

        if (remaining == 0) {
            count = 1;
        }

        count += countFrom(node.left, remaining);
        count += countFrom(node.right, remaining);

        return count;
    }
}