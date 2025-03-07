public class Solution {
    public int heightChecker(int[] heights) {
        int result = 0;
        int n = heights.length;
        int[] expected = new int[n];

        for (int i = 0; i < n; i++) {
            expected[i] = heights[i];
        }

        Arrays.sort(expected);

        for (int i = 0; i < n; i++) {
            if (expected[i] != heights[i]) {
                result += 1;
            }
        }
        return result;
    }
}
