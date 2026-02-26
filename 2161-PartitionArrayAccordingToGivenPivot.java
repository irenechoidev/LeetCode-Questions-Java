class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < pivot) {
                less += 1;
            } else if (num == pivot) {
                equal += 1;
            }
        }

        int[] res = new int[nums.length];
        int lessI = 0;
        int equalI = less;
        int greaterI = less + equal;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                res[lessI] = nums[i];
                lessI += 1;
            } else if (nums[i] == pivot) {
                res[equalI] = nums[i];
                equalI += 1;
            } else {
                res[greaterI] = nums[i];
                greaterI += 1;
            }
        }
        return res;
    }
}
