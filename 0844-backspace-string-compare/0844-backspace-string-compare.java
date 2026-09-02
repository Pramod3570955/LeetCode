class Solution {
    public boolean backspaceCompare(String s, String t) {

        String a = buildString(s);
        String b = buildString(t);

        return a.equals(b);
    }

    private String buildString(String s) {

        StringBuilder sb = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}