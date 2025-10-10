class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int[] nums1 = copyRange(nums, 0, n - 1);
        int[] nums2 = copyRange(nums, 1, n);

        return Math.max(dp(nums1), dp(nums2));
    }

    private int dp(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);

        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], memo[i - 2] + nums[i]);
        }

        return Math.max(memo[n - 1], memo[n - 2]);
    }

    private int[] copyRange(int[] arr, int start, int end) {
        int[] newArr = new int[end - start];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[start + i];
        }
        return newArr;
    }
}
