public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1)
            return intervals;
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);

        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                current = intervals[i];
                list.add(current);
            }
        }

        return listToArr(list, 2);
    }

    private int[][] listToArr(List<int[]> list, int col) {
        int[][] result = new int[list.size()][col];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
