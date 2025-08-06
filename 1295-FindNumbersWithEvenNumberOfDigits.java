class Solution {
    public int findNumbers(int[] nums) {

        int res = 0;

        for (int n : nums) {

            int count = 0;

            while (n > 0) {
                count += 1;
                n /= 10;
            }

            if (count % 2 == 0) {
                res += 1;
            }
        }

        return res;
    }
}