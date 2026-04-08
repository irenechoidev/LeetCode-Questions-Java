class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] < nums[i]) {
                count += 1;
            } else {
                count = 1;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}