class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        int totalPoisonedTime = 0;

        for (int i = 1; i < timeSeries.length; i++) {
            totalPoisonedTime += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }

        totalPoisonedTime += duration;
        return totalPoisonedTime;
    }
}
