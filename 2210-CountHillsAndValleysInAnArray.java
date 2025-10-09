class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int left = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                if (nums[left] < nums[i] && nums[i] > nums[i + 1] ||
                        nums[left] > nums[i] && nums[i] < nums[i + 1]) {
                    count += 1;
                }
                left = i;
            }

        }
        return count;
    }
}