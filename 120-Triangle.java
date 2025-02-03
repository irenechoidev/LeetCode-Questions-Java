class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] memo = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                List<Integer> row = triangle.get(i);
                if (j >= 0 && j < row.size()) {
                    memo[i][j] = row.get(j);
                } else {
                    memo[i][j] = Integer.MAX_VALUE;
                }

                int top = getCell(memo, i - 1, j);
                int topLeft = getCell(memo, i - 1, j - 1);

                int path = Math.min(top, topLeft);

                if (path != Integer.MAX_VALUE) {
                    memo[i][j] += path;
                }
            }
        }

        int[] lastRow = memo[n - 1];
        int result = Integer.MAX_VALUE;
        for (int i : lastRow) {
            result = Math.min(i, result);
        }
        return result;
    }

    private int getCell(int[][] memo, int i, int j) {
        if (i < 0 || i >= memo.length || j < 0 || j >= memo[0].length)
            return Integer.MAX_VALUE;
        return memo[i][j];
    }
}
