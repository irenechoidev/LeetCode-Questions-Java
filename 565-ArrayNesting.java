class Solution {
    public int arrayNesting(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != -1) {
                int start = i;
                int path = 0;

                while (nums[start] != -1) {
                    int prev = start;

                    start = nums[start];
                    path += 1;

                    nums[prev] = -1;
                }

                result = Math.max(path, result);
            }
        }

        return result;
    }
}