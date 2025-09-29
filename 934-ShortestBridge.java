class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();

        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, directions, visited, queue);
                    found = true;
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : directions) {
                    int row = curr[0] + d[0];
                    int col = curr[1] + d[1];

                    if (row < 0 || col < 0 || row >= n || col >= n || visited[row][col])
                        continue;

                    if (grid[row][col] == 1)
                        return level;

                    visited[row][col] = true;
                    queue.add(new int[] { row, col });
                }
            }
            level += 1;
        }

        return -1;
    }

    private void dfs(int[][] grid, int i, int j, int[][] directions, boolean[][] visited, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length
                || visited[i][j] || grid[i][j] != 1)
            return;

        visited[i][j] = true;
        queue.add(new int[] { i, j });

        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1], directions, visited, queue);
        }
    }
}
