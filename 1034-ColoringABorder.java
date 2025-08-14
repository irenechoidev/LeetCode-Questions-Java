class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        int originalColor = grid[row][col];
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        List<int[]> borders = new ArrayList<>();

        queue.add(new int[] { row, col });
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();

                boolean isBorder = false;

                for (int[] d : directions) {
                    int nextRow = curr[0] + d[0];
                    int nextCol = curr[1] + d[1];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= grid.length || nextCol >= grid[0].length
                            || grid[nextRow][nextCol] != originalColor) {
                        isBorder = true;
                    } else if (!visited[nextRow][nextCol]) {
                        queue.add(new int[] { nextRow, nextCol });
                        visited[nextRow][nextCol] = true;
                    }
                }

                if (isBorder) {
                    borders.add(new int[] { curr[0], curr[1] });
                }
            }
        }

        for (int[] border : borders) {
            grid[border[0]][border[1]] = color;
        }

        return grid;
    }
}