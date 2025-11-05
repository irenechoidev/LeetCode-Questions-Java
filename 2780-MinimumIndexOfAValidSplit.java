class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int i : nums) {
            rightMap.put(i, rightMap.getOrDefault(i, 0) + 1);
        }

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            leftMap.put(n, leftMap.getOrDefault(n, 0) + 1);
            rightMap.put(n, rightMap.get(n) - 1);

            int leftLen = i + 1;
            int rightLen = nums.size() - i - 1;
            if (2 * leftMap.get(n) > leftLen && 2 * rightMap.get(n) > rightLen)
                return i;
        }

        return -1;
    }
}