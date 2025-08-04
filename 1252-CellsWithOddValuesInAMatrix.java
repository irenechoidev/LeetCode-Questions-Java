class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int result = 0;
        int[][] grid = new int[m][n];

        for (int[] idx : indices) {
            int r = idx[0];
            int c = idx[1];

            for (int i = 0; i < n; i++) {
                grid[r][i] += 1;
            }

            for (int j = 0; j < m; j++) {
                grid[j][c] += 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % 2 != 0) {
                    result += 1;
                }
            }
        }

        return result;
    }
}