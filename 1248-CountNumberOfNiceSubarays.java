class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                nums[i] = 0;
            else {
                nums[i] = 1;
            }
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int n : nums) {

            sum += n;
            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
