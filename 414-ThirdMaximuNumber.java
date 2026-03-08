class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;

        for (int n : nums) {

            if (n == max || n == secondMax || n == thirdMax)
                continue;

            if (n >= max) {
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            } else if (n >= secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (n >= thirdMax) {
                thirdMax = n;
            }
        }

        if (thirdMax == Long.MIN_VALUE) {
            return (int) max;
        }

        return (int) thirdMax;
    }
}
