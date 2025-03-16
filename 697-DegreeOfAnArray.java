class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> firstIdx = new HashMap<>();

        int degree = 0;
        int minLength = 0;

        for (int i = 0; i < nums.length; i++) {
            firstIdx.put(nums[i], firstIdx.getOrDefault(nums[i], i));
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (map.get(nums[i]) > degree) {
                degree = map.get(nums[i]);
                minLength = i - firstIdx.get(nums[i]) + 1;
            }

            else if (map.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - firstIdx.get(nums[i]) + 1);
            }
        }

        return minLength;
    }
}