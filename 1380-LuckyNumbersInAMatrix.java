class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int minVal = Integer.MAX_VALUE;
            int colIdx = -1;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < minVal) {
                    minVal = matrix[i][j];
                    colIdx = j;
                }
            }

            boolean isMaxInCol = true;
            for (int k = 0; k < m; k++) {
                if (matrix[k][colIdx] > minVal) {
                    isMaxInCol = false;
                    break;
                }
            }

            if (isMaxInCol) {
                result.add(minVal);
            }
        }
        return result;
    }
}