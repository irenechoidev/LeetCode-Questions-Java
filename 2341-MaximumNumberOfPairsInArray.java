class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[0] += entry.getValue() / 2;
            result[1] += entry.getValue() % 2;
        }

        return result;
    }
}
