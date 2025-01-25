class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOrange = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    freshOrange += 1;
                } else if (grid[i][j] == 2) {
                    queue.add(new int[] { i, j });
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
                    if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1)
                        continue;

                    grid[row][col] = 2;
                    freshOrange -= 1;
                    queue.add(new int[] { row, col });
                }
            }
            level += 1;
        }

        return freshOrange != 0 ? -1 : level - 1;
    }
}
