class Solution {
    public List<Integer> fallingSquares(int[][] positions) {

        List<Integer> ans = new ArrayList<>();
        List<int[]> squares = new ArrayList<>();

        int maxHeight = 0;

        for (int[] p : positions) {

            int start = p[0];
            int end = p[0] + p[1];
            int side = p[1];

            int baseHeight = 0;

            for (int[] square : squares) {

                int prevStart = square[0];
                int prevEnd = square[1];
                int prevHeight = square[2];

                // Check if the squares overlap
                if (start < prevEnd && prevStart < end) {
                    baseHeight = Math.max(baseHeight, prevHeight);
                }
            }

            int height = baseHeight + side;

            squares.add(new int[]{start, end, height});

            maxHeight = Math.max(maxHeight, height);

            ans.add(maxHeight);
        }

        return ans;
    }
}