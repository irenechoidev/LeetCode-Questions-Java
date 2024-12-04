class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negatives and out-of-bound values with a placeholder (n + 1)
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) nums[i] = n+1;
        }

         // Step 2: Mark indices corresponding to numbers that exist in the array
        for (int num: nums) {
            int idx = Math.abs(num)-1;
            if (idx < n && nums[idx] > 0) {
                nums[idx] *= -1;
            }
        }

        // Step 3: Find the first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) return i+1;
        }
        return n+1;
    }
}
