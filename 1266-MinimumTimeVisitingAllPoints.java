class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int path = 0;
        for (int i = 1; i < points.length; i++) {
            int[] curr = points[i];
            int[] prev = points[i - 1];

            int x = Math.abs(curr[0] - prev[0]);
            int y = Math.abs(curr[1] - prev[1]);

            path += Math.max(x, y);
        }

        return path;
    }
}
