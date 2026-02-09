class Solution {
    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int start = 0;
        int end = 0;

        while (end < nums.length) {

            if (nums[end] == 0)
                k -= 1;

            if (k < 0) {
                while (nums[start] == 1) {
                    start += 1;
                }
                if (nums[start] == 0) {
                    k += 1;
                    start += 1;
                }
            }

            res = Math.max(res, end - start + 1);
            end += 1;
        }
        return res;
    }
}
