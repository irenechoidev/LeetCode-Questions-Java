class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int diffCount = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                diffCount -= 1;
            } else {
                diffCount += 1;
            }

            if (map.containsKey(diffCount)) {
                res = Math.max(res, i - map.get(diffCount));
            } else {
                map.put(diffCount, i);
            }
        }
        return res;
    }
}