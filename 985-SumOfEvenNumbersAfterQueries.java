class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];
        int evenSum = 0;
        for (int n : nums) {
            if (n % 2 == 0)
                evenSum += n;
        }

        for (int i = 0; i < res.length; i++) {
            int val = queries[i][0];
            int idx = queries[i][1];

            if (nums[idx] % 2 == 0) {
                evenSum -= nums[idx];
            }

            nums[idx] += val;

            if (nums[idx] % 2 == 0) {
                evenSum += nums[idx];
            }

            res[i] += evenSum;
        }
        return res;
    }
}