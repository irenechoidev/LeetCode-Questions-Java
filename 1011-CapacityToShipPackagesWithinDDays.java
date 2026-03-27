class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0;
        int end = 0;

        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (canShipWithCapacity(weights, days, mid)) {
                end = mid; // Try to find a smaller capacity
            } else {
                start = mid + 1; // Need a larger capacity
            }
        }

        return start;
    }

    private boolean canShipWithCapacity(
            int[] weights,
            int days,
            int currentCapacity) {
        int daysUsed = 1;
        int dailyWeight = 0;

        for (int w : weights) {
            if (dailyWeight + w > currentCapacity) {
                daysUsed++;
                dailyWeight = 0;
            }
            dailyWeight += w;
        }

        return daysUsed <= days;
    }
}