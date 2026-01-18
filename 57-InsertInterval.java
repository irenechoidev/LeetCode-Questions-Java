class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i += 1;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i += 1;
        }
        list.add(newInterval);

        while (i < n) {
            list.add(intervals[i]);
            i += 1;
        }

        return listToArr(list);
    }

    private int[][] listToArr(List<int[]> list) {
        int[][] res = new int[list.size()][2];
        int idx = 0;
        for (int[] l : list) {
            res[idx] = l;
            idx += 1;
        }
        return res;
    }
}
