class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    int top = getCell(i - 1, j, memo);
                    int left = getCell(i, j - 1, memo);
                    int diagonal = getCell(i - 1, j - 1, memo);

                    memo[i][j] = Math.min(top, Math.min(left, diagonal)) + matrix[i][j];
                    res += memo[i][j];
                }
            }
        }
        return res;
    }

    private int getCell(int i, int j, int[][] grid) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        return grid[i][j];
    }
}