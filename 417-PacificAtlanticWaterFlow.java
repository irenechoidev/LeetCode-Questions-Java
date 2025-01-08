class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pacific = new boolean[m][n];

        Queue<int[]> aQueue = new LinkedList<>();
        Queue<int[]> pQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            pacific[i][0] = true;
            pQueue.add(new int[] { i, 0 });
            atlantic[i][n - 1] = true;
            aQueue.add(new int[] { i, n - 1 });
        }

        for (int j = 0; j < n; j++) {
            pacific[0][j] = true;
            pQueue.add(new int[] { 0, j });
            atlantic[m - 1][j] = true;
            aQueue.add(new int[] { m - 1, j });
        }

        bfs(heights, atlantic, aQueue, m, n);
        bfs(heights, pacific, pQueue, m, n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    result.add(temp);
                }
            }
        }

        return result;
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<int[]> queue, int m, int n) {
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();

                for (int[] d : directions) {
                    int nextRow = curr[0] + d[0];
                    int nextCol = curr[1] + d[1];

                    if (nextRow < 0 || nextCol < 0 || nextRow >= m || nextCol >= n)
                        continue;
                    if (visited[nextRow][nextCol]
                            || heights[nextRow][nextCol] < heights[curr[0]][curr[1]])
                        continue;

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[] { nextRow, nextCol });
                }
            }
        }
    }
}