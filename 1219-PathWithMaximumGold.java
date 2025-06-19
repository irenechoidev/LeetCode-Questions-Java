class Solution {
    int maxSum = 0;

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0, directions);
                }
            }
        }
        return maxSum;
    }

    private void dfs(int[][] grid, int i, int j, int val, int[][] directions) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            maxSum = Math.max(maxSum, val);
            return;
        }

        int temp = grid[i][j];
        grid[i][j] = 0;

        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1], temp + val, directions);
        }

        grid[i][j] = temp;

    }
}
