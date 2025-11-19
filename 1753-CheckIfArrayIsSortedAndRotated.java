class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return true;

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i])
                count += 1;
            if (count > 1)
                return false;
        }

        if (nums[0] < nums[n - 1])
            count += 1;

        return count <= 1;
    }
}