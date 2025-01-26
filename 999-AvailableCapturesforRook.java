class Solution {
    public int numRookCaptures(char[][] board) {

        int result = 0;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                if (board[i][j] == 'R') {
                    for (int[] d : directions) {
                        int row = i + d[0];
                        int col = j + d[1];

                        while (row >= 0 && row < 8 && col >= 0 && col < 8) {

                            if (board[row][col] == 'p') {
                                result += 1;
                                break;
                            } else if (board[row][col] == 'B') {
                                break;
                            }

                            row += d[0];
                            col += d[1];
                        }

                    }
                }
            }
        }
        return result;
    }
}
