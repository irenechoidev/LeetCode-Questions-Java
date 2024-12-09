class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j });
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : directions) {
                    int nextRow = curr[0] + d[0];
                    int nextCol = curr[1] + d[1];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
                            || mat[nextRow][nextCol] != Integer.MAX_VALUE)
                        continue;

                    mat[nextRow][nextCol] = mat[curr[0]][curr[1]] + 1;
                    queue.add(new int[] { nextRow, nextCol });
                }

            }
        }
        return mat;
    }
}
