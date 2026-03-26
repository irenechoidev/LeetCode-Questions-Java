class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int max = findMax(quantities);

        int start = 1;
        int end = max;

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            for (int q : quantities) {
                sum += q / mid;
                if (q % mid != 0) {
                    sum += 1;
                }
            }
            if (sum > n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int findMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}