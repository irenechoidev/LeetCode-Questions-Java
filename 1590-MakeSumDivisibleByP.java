class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int target = (int) (totalSum % p);
        if (target == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int len = nums.length;
        long currentPrefix = 0;

        for (int i = 0; i < nums.length; i++) {
            currentPrefix = (currentPrefix + nums[i]) % p;

            int previousPrefix = (int) ((currentPrefix - target + p) % p);

            if (map.containsKey(previousPrefix)) {
                len = Math.min(len, i - map.get(previousPrefix));
            }

            map.put((int) currentPrefix, i);
        }
        return len == nums.length ? -1 : len;
    }
}