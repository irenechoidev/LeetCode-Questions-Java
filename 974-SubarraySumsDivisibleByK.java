class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int num : nums) {
            sum += num;
            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                res += map.get(remainder);
            }

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return res;
    }
}