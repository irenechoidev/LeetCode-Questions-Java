class Solution {
    public int minCost(String colors, int[] neededTime) {
        int totalCost = 0;
        int n = colors.length();
        int start = 0;

        while (start < n) {
            int end = start;
            int runSum = 0;
            int runMax = 0;
            while (end < n && colors.charAt(start) == colors.charAt(end)) {
                runSum += neededTime[end];
                runMax = Math.max(runMax, neededTime[end]);
                end += 1;
            }

            totalCost += runSum - runMax;
            start = end;
        }
        return totalCost;
    }
}