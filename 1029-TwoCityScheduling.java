class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int result = 0;

        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                result += costs[i][0];
            } else {
                result += costs[i][1];
            }
        }

        return result;
    }
}