class Solution {
    public int maximumGap(int[] nums) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        if (nums.length < 2)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            int diff = Math.abs(nums[i] - nums[i - 1]);
            max = Math.max(max, diff);
        }
        return max;
    }
}
