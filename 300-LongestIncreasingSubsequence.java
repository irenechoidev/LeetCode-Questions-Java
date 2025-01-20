class Solution {
    public int lengthOfLIS(int[] nums) {

        int[] memo = new int[nums.length];
        memo[0] = 1;

        int result = memo[0];

        for (int i = 1; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                } else {
                    memo[i] = Math.max(memo[i], 1);
                }
            }
            result = Math.max(result, memo[i]);
        }
        return result;
    }
}
