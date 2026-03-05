class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { rCenter, cCenter });
        visited[rCenter][cCenter] = true;

        int idx = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.remove();
            res[idx] = curr;
            idx += 1;

            for (int[] d : directions) {
                int row = curr[0] + d[0];
                int col = curr[1] + d[1];

                if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row][col]) {
                    queue.add(new int[] { row, col });
                    visited[row][col] = true;
                }
            }
        }
        return res;
    }
}