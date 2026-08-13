class Solution {

    class Node {
        char leftChar;
        char rightChar;
        int prefix;
        int suffix;
        int best;
        int length;

        Node(char leftChar, char rightChar, int prefix,
             int suffix, int best, int length) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
            this.length = length;
        }
    }

    Node[] tree;

    Node merge(Node left, Node right) {

        if (left == null) return right;
        if (right == null) return left;

        int prefix = left.prefix;
        int suffix = right.suffix;
        int best = Math.max(left.best, right.best);

        if (left.rightChar == right.leftChar) {

            best = Math.max(best, left.suffix + right.prefix);

            if (left.prefix == left.length) {
                prefix = left.length + right.prefix;
            }

            if (right.suffix == right.length) {
                suffix = right.length + left.suffix;
            }
        }

        return new Node(
            left.leftChar,
            right.rightChar,
            prefix,
            suffix,
            best,
            left.length + right.length
        );
    }

    void build(char[] s, int node, int l, int r) {

        if (l == r) {
            tree[node] = new Node(
                s[l], s[l],
                1, 1, 1, 1
            );
            return;
        }

        int mid = l + (r - l) / 2;

        build(s, node * 2, l, mid);
        build(s, node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    void update(char[] s, int node, int l, int r,
                int index, char c) {

        if (l == r) {
            s[index] = c;

            tree[node] = new Node(
                c, c,
                1, 1, 1, 1
            );
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(s, node * 2, l, mid, index, c);
        } else {
            update(s, node * 2 + 1, mid + 1, r, index, c);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    public int[] longestRepeating(
        String s,
        String queryCharacters,
        int[] queryIndices
    ) {

        int n = s.length();

        tree = new Node[4 * n];

        char[] chars = s.toCharArray();
        char[] queries = queryCharacters.toCharArray();

        build(chars, 1, 0, n - 1);

        int[] answer = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            update(
                chars,
                1,
                0,
                n - 1,
                queryIndices[i],
                queries[i]
            );

            answer[i] = tree[1].best;
        }

        return answer;
    }
}