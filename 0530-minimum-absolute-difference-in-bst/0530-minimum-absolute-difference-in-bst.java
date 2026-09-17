class Solution {

    private Integer prev = null;
    private int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        // call inorder traversal
        inorder(root);

        return min;
    }

    private void inorder(TreeNode node) {

        if (node == null) {
            return;
        }

        // 1. Traverse left
        inorder(node.left);

        // 2. Process current node
        
        if (prev != null) {
            // calculate difference
            min = Math.min(min, node.val - prev);
        }
        

        // 3. Update prev
        prev = node.val;

        // 4. Traverse right
        inorder(node.right);
        if(prev != null){

        }
        prev = node.val;
        inorder(node.right);

    }
}