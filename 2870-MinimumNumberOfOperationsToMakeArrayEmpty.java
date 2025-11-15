class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int n = entry.getValue();

            if (n == 1)
                return -1;

            res += n / 3;
            if (n % 3 != 0)
                res += 1;
        }
        return res;
    }
}
