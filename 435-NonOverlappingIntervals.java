class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int[] firstElement = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (firstElement[1] > intervals[i][0]) {
                res += 1;
            } else {
                firstElement = intervals[i];
            }
        }

        return res;
    }
}