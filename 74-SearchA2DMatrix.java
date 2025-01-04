class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;

        int start = 0;
        int end = (row * column) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int mid_element = matrix[mid / column][mid % column];

            if (mid_element == target) {
                return true;
            } else if (mid_element > target) {
                end = mid - 1;
            } else if (mid_element < target) {
                start = mid + 1;
            }
        }

        return false;
    }
}
