class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < memo.length; i++) {
                memo[i] = memo[i - coin] + memo[i];
            }
        }
        return memo[amount];
    }
}
