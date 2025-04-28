class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        boolean sorted = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                min = Math.min(min, nums[i]);
            }
        }

        int max = Integer.MIN_VALUE;
        sorted = true;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                max = Math.max(max, nums[i - 1]);
            }
        }

        int start = 0, end = 0;
        for (start = 0; start < nums.length; start++) {
            if (nums[start] > min)
                break;
        }

        for (end = nums.length - 1; end >= 0; end--) {
            if (nums[end] < max)
                break;
        }

        return (end < start) ? 0 : end - start + 1;
    }
}