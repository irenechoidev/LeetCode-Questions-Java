class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res = 0;
        int sum = 0;
        int target = k * threshold;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (i >= k) {
                sum -= arr[i - k];
            }

            if (i >= k - 1 && sum >= target) {
                res += 1;
            }
        }
        return res;
    }
}