class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 },
                { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

        // 1. If a mine 'M' is revealed, then the game is over. You should change it to
        // 'X'.
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        } else {
            dfs(click[0], click[1], board, directions);
        }

        // Return the board when no more squares will be revealed.
        return board;
    }

    private void dfs(int i, int j, char[][] board, int[][] directions) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E')
            return;

        int mines = countAdjMines(i, j, board, directions);

        // 3. If an empty square 'E' with at least one adjacent mine is revealed,
        // then change it to a digit ('1' to '8') representing the number of adjacent
        // mines.
        if (mines != 0) {
            board[i][j] = (char) (mines + '0');
        }

        // 2. If an empty square 'E' with no adjacent mines is revealed,
        // then change it to a revealed blank 'B'
        // and all of its adjacent unrevealed squares should be revealed recursively.
        else if (mines == 0) {
            board[i][j] = 'B';
            for (int[] d : directions) {
                dfs(i + d[0], j + d[1], board, directions);
            }
        }
    }

    private int countAdjMines(int i, int j, char[][] board, int[][] directions) {
        int result = 0;

        for (int[] d : directions) {
            int row = i + d[0];
            int col = j + d[1];

            if (row >= 0 && row < board.length && col >= 0 &&
                    col < board[0].length && board[row][col] == 'M') {
                result += 1;
            }
        }
        return result;
    }
}
