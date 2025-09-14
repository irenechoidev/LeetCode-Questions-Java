class Solution {
    public int findMaxFish(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] != 0) {
                    int count = dfs(grid, i, j, directions);
                    result = Math.max(result, count);
                }
            }
        }
        return result;
    }

    private int dfs(int[][] grid, int i, int j, int[][] directions) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        int count = grid[i][j];
        grid[i][j] = 0;
        for (int[] d : directions) {
            count += dfs(grid, i + d[0], j + d[1], directions);
        }
        return count;
    }
}
