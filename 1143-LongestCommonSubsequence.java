class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] memo = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int topVal = getCell(memo, i - 1, j);
                int leftVal = getCell(memo, i, j - 1);
                int diagVal = getCell(memo, i - 1, j - 1);

                int len = -1;
                if (text1.charAt(i) == text2.charAt(j)) {
                    len = diagVal + 1;
                } else {
                    len = Math.max(topVal, leftVal);
                }

                memo[i][j] = len;
            }
        }
        return memo[m - 1][n - 1];
    }

    private int getCell(int[][] memo, int i, int j) {
        if (i < 0 || j < 0 || i >= memo.length || j >= memo[0].length) {
            return 0;
        }
        return memo[i][j];
    }
}
