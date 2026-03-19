class Solution {
    public String tictactoe(int[][] moves) {
        String[][] board = new String[3][3];

        for (String[] row : board)
            Arrays.fill(row, "E");

        int player = 0;

        for (int[] move : moves) {
            if (player == 0) {
                board[move[0]][move[1]] = "A";
                player += 1;
            } else {
                board[move[0]][move[1]] = "B";
                player -= 1;
            }
        }

        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != "E") {
                if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])) {
                    return board[i][0];
                }
            }
        }

        // check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != "E") {
                if (board[0][j].equals(board[1][j]) && board[1][j].equals(board[2][j])) {
                    return board[0][j];
                }
            }
        }

        // check diagonal from top left
        if (board[0][0] != "E") {
            if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
                return board[0][0];
            }
        }

        // check diagonal from top right
        if (board[0][2] != "E") {
            if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0])) {
                return board[0][2];
            }
        }

        return moves.length == 9 ? "Draw" : "Pending";
    }
}