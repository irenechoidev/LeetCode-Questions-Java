class Solution {
    public int waysToSplitArray(int[] nums) {
        int res = 0;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum;
            if (leftSum >= rightSum)
                res += 1;
            leftSum += nums[i];
        }

        return res;
    }
}