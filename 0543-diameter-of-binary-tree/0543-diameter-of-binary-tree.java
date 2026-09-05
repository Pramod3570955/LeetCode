class Solution {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        // Diameter passing through current node
        diameter = Math.max(diameter, left + right);

        // Return height of current subtree
        return 1 + Math.max(left, right);
    }
}