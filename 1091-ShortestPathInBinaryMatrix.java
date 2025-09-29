class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1)
            return -1;

        int n = grid.length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 },
                { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { 0, 0 });

        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                if (curr[0] == n - 1 && curr[1] == n - 1)
                    return level;

                for (int[] d : directions) {
                    int row = curr[0] + d[0];
                    int col = curr[1] + d[1];

                    if (row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != 0)
                        continue;

                    grid[row][col] = 1;
                    queue.add(new int[] { row, col });

                }
            }
            level += 1;
        }

        return -1;
    }
}