class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {

                    for (int num = 1; num <= 9; num++) {
                        char c = (char) (num + '0'); // Convert number to character
                        if (isValid(i, j, board, c)) {
                            board[i][j] = c;
                            if (backtrack(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(int row, int col, char[][] board, char c) {
        int firstRowInBox = 3 * (row / 3);
        int firstColInBox = 3 * (col / 3);

        for (int n = 0; n < 9; n++) {
            if (board[row][n] == c)
                return false;
            if (board[n][col] == c)
                return false;
            if (board[firstRowInBox + n / 3][firstColInBox + n % 3] == c)
                return false;
        }
        return true;
    }
}
