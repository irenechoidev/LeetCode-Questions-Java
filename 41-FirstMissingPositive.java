class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Replace negatives and out-of-bound values(0) with a placeholder (n + 1)
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

        // The valid range of the first missing positive integer is between 1 and n+1, where n is size of array.
        // After the third loop (where you check for the first positive value in the array), 
        // if no positive index is found, it means all numbers from 1 to n are present.
        // Thus, the smallest missing positive integer is the next number after n, which is n+1
        return n+1;
    }
}
