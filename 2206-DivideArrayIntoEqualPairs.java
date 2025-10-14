class Solution {
    public boolean divideArray(int[] nums) {
        if (nums.length % 2 != 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0)
                return false;
        }

        return true;
    }
}
