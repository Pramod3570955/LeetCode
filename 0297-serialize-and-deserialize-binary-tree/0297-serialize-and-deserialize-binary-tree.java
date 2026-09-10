public class Codec {

    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        serializeHelper(root, sb);

        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");

        index = 0;

        return deserializeHelper(values);
    }

    private TreeNode deserializeHelper(String[] values) {

        String value = values[index++];

        if (value.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = deserializeHelper(values);

        root.right = deserializeHelper(values);

        return root;
    }
}