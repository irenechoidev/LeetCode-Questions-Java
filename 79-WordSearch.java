class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, i, j, word, 0, directions))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx, int[][] directions) {
        if (idx == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
                board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        for (int[] d : directions) {
            if (dfs(board, i + d[0], j + d[1], word, idx + 1, directions))
                return true;
        }

        board[i][j] = temp;
        return false;
    }
}
