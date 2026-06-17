class Solution {
    public int minPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {

            max = Math.max(max, nums[start] + nums[end]);
            start += 1;
            end -= 1;
        }
        return max;
    }
}
