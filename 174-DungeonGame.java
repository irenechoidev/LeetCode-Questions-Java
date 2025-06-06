class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] table = new int[m + 1][n + 1];

        for (int i = 0; i < table.length; i++) {
            Arrays.fill(table[i], Integer.MAX_VALUE);
        }

        table[m][n - 1] = 1;
        table[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int bottom = table[i + 1][j];
                int right = table[i][j + 1];

                int minHealthPower = Math.min(bottom, right) - dungeon[i][j];

                table[i][j] = minHealthPower <= 0 ? 1 : minHealthPower;
            }
        }
        return table[0][0];
    }
}