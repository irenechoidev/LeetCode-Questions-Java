class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = Integer.MIN_VALUE;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == '1') {
                    memo[i][j] = 1;

                    int top = getCell(memo, i - 1, j);
                    int left = getCell(memo, i, j - 1);
                    int diagonal = getCell(memo, i - 1, j - 1);

                    memo[i][j] += Math.min(left, Math.min(top, diagonal));
                    res = Math.max(res, memo[i][j]);
                }
            }
        }

        return res * res;
    }

    private int getCell(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return 0;
        return grid[i][j];
    }
}