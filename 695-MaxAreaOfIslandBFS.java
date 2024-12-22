class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = 0;

                    grid[i][j] = 0;
                    stack.push(new int[] { i, j });

                    while (!stack.isEmpty()) {
                        int[] curr = stack.pop();
                        count += 1;

                        for (int[] d : directions) {
                            int row = curr[0] + d[0];
                            int col = curr[1] + d[1];

                            if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] != 1)
                                continue;

                            grid[row][col] = 0;
                            stack.push(new int[] { row, col });
                        }
                    }

                    result = Math.max(count, result);
                }
            }
        }
        return result;
    }
}
