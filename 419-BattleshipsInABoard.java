class Solution {
    public int countBattleships(char[][] board) {
        int res = 0;
        int m = board.length;
        int n = board[0].length;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    res += 1;
                    dfs(i, j, board, directions);
                }
            }
        }
        return res;
    }

    private void dfs(int i, int j, char[][] board, int[][] directions) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'X')
            return;
        board[i][j] = '.';
        for (int[] d : directions) {
            dfs(i + d[0], j + d[1], board, directions);
        }
    }
}