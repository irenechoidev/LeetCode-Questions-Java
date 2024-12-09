class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] memo = new int[amount + 1];

        // If i = 0, the condition i - coin >= 0 would never be true for any positive
        // coin.
        for (int i = 1; i < memo.length; i++) {

            memo[i] = Integer.MAX_VALUE;
            // memo = [0, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞, ∞]

            for (int coin : coins) {

                // If memo[i - coin] == Integer.MAX_VALUE, it means that
                // the amount (i - coin) cannot be formed using the available coins.
                if (i - coin >= 0 && memo[i - coin] != Integer.MAX_VALUE) {

                    memo[i] = Math.min(memo[i], memo[i - coin] + 1);

                }
            }
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}