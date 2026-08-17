class Solution {
    public String simplifyPath(String path) {

        String[] parts = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String part : parts) {

            // Empty or current directory
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go back
            if (part.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                // Normal directory
                stack.push(part);
            }
        }

        // Build result
        StringBuilder result = new StringBuilder();

        for (String dir : stack) {
            result.append("/").append(dir);
        }

        // If empty, root directory
        if (result.length() == 0) {
            return "/";
        }

        return result.toString();
    }
}