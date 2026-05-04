class Solution {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {

            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> colSet = new HashSet<>();
            for (int j = 0; j < n; j++) {

                if (rowSet.contains(matrix[i][j]))
                    return false;
                rowSet.add(matrix[i][j]);

                if (colSet.contains(matrix[j][i]))
                    return false;
                colSet.add(matrix[j][i]);
            }
        }

        return true;
    }
}
