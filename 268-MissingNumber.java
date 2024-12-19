class Solution {
    public int missingNumber(int[] nums) {
        int result = 0;
        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            result += i;
        }

        for (int i : nums) {
            result -= i;
        }

        return result;
    }
}
