class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            freq[Math.min(n, nums[i])]++;
        }

        int numGreaterThanOrEqual = 0;
        for (int i = n; i >= 1; i--) {
            numGreaterThanOrEqual += freq[i];
            if (numGreaterThanOrEqual == i)
                return i;
        }

        return -1;
    }
}