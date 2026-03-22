class Solution {
    public int arrangeCoins(int n) {

        int row = 0;
        int coin = 1;

        while (n > 0) {
            n -= coin;
            if (n < 0)
                return row;

            row += 1;
            coin += 1;
        }

        return row;
    }
}
