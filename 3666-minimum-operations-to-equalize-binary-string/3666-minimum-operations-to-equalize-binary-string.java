import java.util.*;

class Solution {
    public int minOperations(String s, int k) {
        int n = s.length();

        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            sets[i % 2].add(i);
        }

        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                zeros++;
            }
        }

        sets[zeros % 2].remove(zeros);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(zeros);

        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int cur = queue.poll();

                if (cur == 0) {
                    return ans;
                }

                int left = cur + k - 2 * Math.min(cur, k);
                int right = cur + k - 2 * Math.max(k - n + cur, 0);

                TreeSet<Integer> set = sets[left % 2];

                Integer next = set.ceiling(left);
                while (next != null && next <= right) {
                    queue.offer(next);
                    set.remove(next);
                    next = set.ceiling(left);
                }
            }

            ans++;
        }

        return -1;
    }
}