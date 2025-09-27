class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 },
                { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

        for (int[] d : directions) {
            int count = 1;

            int row = rMove + d[0];
            int col = cMove + d[1];

            boolean isLineEnd = false;
            while (isInBound(board, row, col)) {
                count += 1;
                if (board[row][col] == color) {
                    isLineEnd = true;
                    break;
                }

                row += d[0];
                col += d[1];
            }

            if (isLineEnd && count >= 3)
                return true;

        }

        return false;
    }

    private boolean isInBound(char[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] != '.';
    }
}