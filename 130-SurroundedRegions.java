class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, directions);
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1, directions);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, directions);
            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j, directions);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '!') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, int[][] directions) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '!' || board[i][j] == 'X') {
            return;
        }
        board[i][j] = '!';
        for (int[] d : directions) {
            dfs(board, i + d[0], j + d[1], directions);
        }
    }
}