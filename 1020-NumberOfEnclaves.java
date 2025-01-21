class Solution {
    public int numEnclaves(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 1)
                dfs(grid, i, 0, directions);
            if (grid[i][n - 1] == 1)
                dfs(grid, i, n - 1, directions);
        }

        for (int j = 0; j < n; j++) {
            if (grid[0][j] == 1)
                dfs(grid, 0, j, directions);
            if (grid[m - 1][j] == 1)
                dfs(grid, m - 1, j, directions);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    result += 1;
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j, int[][] directions) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1)
            return;

        grid[i][j] = 0;
        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1], directions);
        }
    }
}