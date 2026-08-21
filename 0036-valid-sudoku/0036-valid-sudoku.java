class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> rows = new HashSet<>();
        HashSet<String> cols = new HashSet<>();
        HashSet<String> boxes = new HashSet<>();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                char c = board[i][j];

                if (c == '.') {
                    continue;
                }

                String rowKey = i + "-" + c;

                if (!rows.add(rowKey)) {
                    return false;
                }

                String colKey = j + "-" + c;

                if (!cols.add(colKey)) {
                    return false;
                }

                String boxKey = (i / 3) + "-" + (j / 3) + "-" + c;

                if (!boxes.add(boxKey)) {
                    return false;
                }
            }
        }

        return true;
    }
}