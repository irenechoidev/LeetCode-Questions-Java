class Solution {
    public int countHomogenous(String s) {
        long res = 0;
        final long MOD = 1_000_000_007;
        int start = 0;

        while (start < s.length()) {
            int end = start;
            while (end < s.length() && s.charAt(start) == s.charAt(end)) {
                end += 1;
            }
            long n = end - start;
            res += (n * (n + 1) / 2) % MOD;
            start = end;
        }
        return (int) res;
    }
}