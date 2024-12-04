class Solution {
    public boolean isPalindrome(int x) {

        // 1. Handle Negative Numbers
        if (x < 0)
            return false;

        // 2. Initialize Variables
        int reverse = 0;
        // keep first 'x' value to variable 'original' to check later in the end
        int original = x;

        // 3. Reverse the Digits

        // ** while(x != 0) **
        // Natural Stopping Condition for Reversing Digits
        // As you reverse x, the integer x shrinks by removing its last digit in each iteration: x /= 10.
        // The condition x != 0 ensures the loop stops only when all digits have been processed.
        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == original;
    }
}
