class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] memo = new int[lastDay + 1];

        Set<Integer> set = arrToSet(days);

        for (int i = 1; i < memo.length; i++) {
            if (set.contains(i)) {
                int oneDayBefore = getCellVal(memo, i - 1) + costs[0];
                int sevenDaysBefore = getCellVal(memo, i - 7) + costs[1];
                int thirtyDaysBefore = getCellVal(memo, i - 30) + costs[2];

                memo[i] = Math.min(oneDayBefore, Math.min(sevenDaysBefore, thirtyDaysBefore));
            } else {
                memo[i] = memo[i - 1];
            }
        }
        return memo[lastDay];
    }

    private Set<Integer> arrToSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        return set;
    }

    private int getCellVal(int[] arr, int val) {
        if (val < 0 || val >= arr.length)
            return 0;
        return arr[val];
    }
}