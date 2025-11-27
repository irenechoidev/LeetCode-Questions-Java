class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int mappedNum = 0;
            int base = 1;
            if (num == 0) {
                mappedNum = mapping[0];
            } else {
                while (num > 0) {
                    int digit = num % 10;
                    num /= 10;

                    mappedNum += mapping[digit] * base;
                    base *= 10;
                }
            }

            pairs[i][0] = mappedNum;
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = nums[pairs[i][1]];
        }

        return res;
    }
}
