class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int max = 0;
        Arrays.sort(points, (a, b) -> b[0] - a[0]);
        for (int i = 1; i < points.length; i++) {
            max = Math.max(max, points[i][0] - points[i - 1][0]);
        }

        return max;
    }
}