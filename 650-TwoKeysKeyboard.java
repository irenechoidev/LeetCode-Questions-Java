class Solution {
    public int minSteps(int n) {
        int[] memo = new int[n + 1];

        for (int i = 2; i < memo.length; i++) {
            memo[i] = i;
            for (int j = i - 1; j >= 0; j--) {
                if (i % j == 0) {
                    memo[i] = memo[j] + i / j;
                    break;
                }
            }
        }
        return memo[n];
    }
}
