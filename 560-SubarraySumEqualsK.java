public class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i : nums) {
            sum += i;

            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
