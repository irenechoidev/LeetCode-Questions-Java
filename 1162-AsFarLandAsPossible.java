class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] { i, j });
                }
            }
        }

        if (queue.size() == n * n || queue.size() == 0)
            return -1;

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] d : directions) {
                    int nextRow = row + d[0];
                    int nextCol = col + d[1];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= n || nextCol >= n ||
                            grid[nextRow][nextCol] != 0)
                        continue;

                    grid[nextRow][nextCol] = 1;
                    queue.add(new int[] { nextRow, nextCol });
                }
            }
            level += 1;
        }

        return level - 1;

    }
}
