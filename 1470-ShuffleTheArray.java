class Solution {
    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[nums.length];
        int start = 0;

        for (int i = 0; i < result.length - 1; i += 2) {

            result[i] = nums[start];
            start += 1;

            result[i + 1] = nums[n];
            n += 1;

        }
        return result;

    }
}
