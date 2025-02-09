class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(result, board, 0);
        return result;
    }

    private void backtrack(List<List<String>> result, char[][] board, int row) {
        if (row == board.length) {
            result.add(constructSolution(board));
            return;
        }

        for (int j = 0; j < board.length; j++) {
            if (isValid(board, row, j)) {
                board[row][j] = 'Q';
                backtrack(result, board, row + 1);
                board[row][j] = '.';
            }
        }
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'Q' && (col == j || row + j == col + i || row + col == i + j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private List<String> constructSolution(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] row : board) {
            list.add(String.valueOf(row));
        }

        return list;
    }
}