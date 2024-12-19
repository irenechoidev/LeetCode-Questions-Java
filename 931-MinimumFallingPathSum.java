class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int top = getCell(matrix, i - 1, j);
                int top_left = getCell(matrix, i - 1, j - 1);
                int top_right = getCell(matrix, i - 1, j + 1);

                int path = Math.min(top, Math.min(top_left, top_right));

                if (path != Integer.MAX_VALUE) {
                    matrix[i][j] += path;
                }
            }
        }

        int result = Integer.MAX_VALUE;
        int[] lastRow = matrix[m - 1];
        for (int i : lastRow) {
            result = Math.min(result, i);
        }
        return result;
    }

    private int getCell(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        return grid[i][j];
    }
}