class Solution {
    public int minMoves2(int[] nums) {
        int result = 0;
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            result += nums[end] - nums[start];
            end -= 1;
            start += 1;
        }

        return result;
    }
}
