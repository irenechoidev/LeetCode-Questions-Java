class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                memo[i][j] = grid[i][j];

                int top = getCell(memo, i - 1, j);
                int left = getCell(memo, i, j - 1);

                int path = Math.min(left, top);

                if (path != Integer.MAX_VALUE) {
                    memo[i][j] += path;
                }

            }
        }
        return memo[m - 1][n - 1];
    }

    private int getCell(int[][] memo, int i, int j) {
        if (i < 0 || i >= memo.length || j < 0 || j >= memo[0].length)
            return Integer.MAX_VALUE;
        return memo[i][j];
    }
}
