class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();

        // Empty tree
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        // Add root
        queue.offer(root);

        while (!queue.isEmpty()) {

            // Number of nodes in current level
            int size = queue.size();

            // Sum of current level
            double sum = 0;

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                // Add node value
                sum += node.val;

                // Add left child
                if (node.left != null) {
                    queue.offer(node.left);
                }

                // Add right child
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // Calculate and store average
            double average = sum / size;
            result.add(average);
        }

        return result;
    }
}