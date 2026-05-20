class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            if (map.containsKey(nums[i])) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getKey() < nums[i]) {
                        res[i] += entry.getValue();
                    }
                }
            }
        }
        return res;
    }
}
