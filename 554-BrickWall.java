public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for (List<Integer> row : wall) {
            int total = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                total += row.get(i);
                map.put(total, map.getOrDefault(total, 0) + 1);
            }
        }

        int maxGaps = 0;
        for (int count : map.values()) {
            maxGaps = Math.max(maxGaps, count);
        }

        return wall.size() - maxGaps;
    }
}