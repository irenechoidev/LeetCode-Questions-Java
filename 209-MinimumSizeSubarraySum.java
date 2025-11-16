class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];

            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                start += 1;
            }

            end += 1;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}