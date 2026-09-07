class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {

            // Case 1: no left child
            if (root.left == null) {
                return root.left != null ? root.left : root.right;
            }

            // Case 2: no right child
            if (root.right == null) {
                return root.right != null ? root.right : root.left;
            }

            // Case 3: two children
            TreeNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.val = successor.val;

            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}