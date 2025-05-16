class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = findMax(nums);

        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;

            for (int n : nums) {
                sum += (int) Math.ceil((double) n / mid);
            }

            if (sum > threshold) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int findMax(int[] arr) {
        int result = 0;
        for (int i : arr) {
            result = Math.max(i, result);

        }
        return result;
    }
}
