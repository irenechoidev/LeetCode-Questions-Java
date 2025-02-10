class Solution {
    int result = 0;

    public int totalNQueens(int n) {

        char[][] board = new char[n][n];

        backtrack(board, 0);
        return result;
    }

    private void backtrack(char[][] board, int row) {
        if (row == board.length) {
            result += 1;
            return;
        }

        for (int j = 0; j < board[row].length; j++) {
            if (isValid(board, row, j)) {
                board[row][j] = 'Q';
                backtrack(board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'Q' && (col == j || row+col == i+j || row+j == col+i)){
                    return false;
                } 
            }
        }
        return true;
    }
