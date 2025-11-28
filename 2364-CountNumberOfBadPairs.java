class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Long> map = new HashMap<>();
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = i - nums[i];

            long count = map.getOrDefault(key, 0L);
            goodPairs += count;

            map.put(key, count + 1);
        }

        long n = nums.length;
        long totalPairs = (n * (n - 1)) / 2;

        return totalPairs - goodPairs;
    }
}