class Solution {
    public int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i += 2) {
            result += nums[i - 1];
        }
        return result;
    }
}
