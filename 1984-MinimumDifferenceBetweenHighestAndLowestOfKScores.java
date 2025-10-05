class Solution {
    public int minimumDifference(int[] nums, int k) {
        int minDiff = Integer.MAX_VALUE;
        if (k == 1)
            return 0;

        Arrays.sort(nums);

        int i = 0;
        int j = k - 1;
        while (j < nums.length) {
            minDiff = Math.min(minDiff, nums[j] - nums[i]);

            i += 1;
            j += 1;
        }
        return minDiff;

    }
}