class Solution {
    public int maxAscendingSum(int[] nums) {

        int sum = nums[0];
        int maxSum = getMax(nums);

        for (int i = 1; i < nums.length; i++) {
            boolean ascending = nums[i - 1] < nums[i];
            if (ascending)
                sum += nums[i];
            else if (!ascending)
                sum = nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    private int getMax(int[] nums) {
        int max = -1;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        return max;
    }
}
