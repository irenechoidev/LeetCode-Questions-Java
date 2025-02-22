class Solution {
    public int numIslands(char[][] grid) {
        int island = 0;

        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    island += 1;
                    dfs(grid, i, j, directions);
                }
            }
        }
        return island;
    }

    private void dfs(char[][] grid, int i, int j, int[][] directions) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
            return;

        grid[i][j] = '0';
        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1], directions);
        }
    }
}