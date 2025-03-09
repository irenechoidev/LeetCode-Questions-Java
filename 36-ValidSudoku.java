class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.')
                    continue;

                String row = board[i][j] + "inRow" + i;
                String col = board[i][j] + "inCol" + j;
                String box = board[i][j] + "inBox" + i / 3 + j / 3;

                if (set.contains(row) || set.contains(col) || set.contains(box))
                    return false;

                set.add(row);
                set.add(col);
                set.add(box);
            }
        }
        return true;
    }
}