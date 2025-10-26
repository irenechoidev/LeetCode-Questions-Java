public class Solution {
    public double averageWaitingTime(int[][] customers) {
        long chefAvailableAt = 0;
        long totalWaitingTime = 0;

        for (int[] c : customers) {
            int arrival = c[0];
            int prepTime = c[1];

            chefAvailableAt = Math.max(chefAvailableAt, arrival) + prepTime;
            totalWaitingTime += chefAvailableAt - arrival;
        }

        return (double) totalWaitingTime / customers.length;
    }
}
