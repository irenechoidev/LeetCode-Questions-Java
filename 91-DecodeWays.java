class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int n = s.length();
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int i = 2; i <= n; i++) {
            int oneDigit = s.charAt(i - 1) - '0';
            if (oneDigit >= 1) {
                memo[i] += memo[i - 1];
            }

            int twoDigits = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            if (twoDigits >= 10 && twoDigits <= 26) {
                memo[i] += memo[i - 2];
            }
        }

        return memo[n];
    }
}
