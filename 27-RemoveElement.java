class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;

                idx += 1;
            }
        }
        return idx;
    }
}
