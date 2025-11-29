class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int start = 0;
        int end = n - 1;
        int idx = n - 1;
        while (start <= end) {
            int startSquare = nums[start] * nums[start];
            int endSquare = nums[end] * nums[end];
            if (startSquare > endSquare) {
                res[idx] = startSquare;
                start += 1;
            } else {
                res[idx] = endSquare;
                end -= 1;
            }
            idx -= 1;
        }
        return res;
    }
}
