class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid[0].length;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], map.getOrDefault(grid[i][j], 0) + 1);
            }
        }

        int[] result = new int[2];
        for (int i = 1; i <= n * n; i++) {
            if (map.containsKey(i) && map.get(i) == 2)
                result[0] = i;
            else if (!map.containsKey(i))
                result[1] = i;
        }

        return result;
    }
}
