class Solution {
    public boolean isPowerOfThree(int n) {
        // if there exists an integer x such that n == 3^x(three to the power of x)

        if (n < 1)
            return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}