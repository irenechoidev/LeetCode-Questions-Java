class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            if (nums[start] < nums[end])
                return nums[start];

            int mid = start + (end - start) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (nums[prev] > nums[mid] && nums[mid] < nums[next])
                return nums[mid];
            else if (nums[mid] < nums[end])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return ' ';
    }
}