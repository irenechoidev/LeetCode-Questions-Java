class Solution {
    public int numSquares(int n) {
        int[] table = new int[n + 1];

        for (int i = 1; i < table.length; i++) {
            table[i] = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {
                table[i] = Math.min(table[i], table[i - (j * j)] + 1);
            }
        }

        return table[n];
    }
}
