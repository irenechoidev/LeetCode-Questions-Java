class Solution {
    public boolean isPowerOfThree(int n) {
        // if there exists an integer x such that n == 3^x(three to the power of x)
        
        // edge case:
        if (n < 1) return false;

        // 3 으로 나누어 지면
        while (n % 3 == 0) {

            // 3 으로 나누어라
            n /= 3;
        }

        
        return n == 1;
    }
}
