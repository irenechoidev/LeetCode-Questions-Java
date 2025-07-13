class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int[] res = new int[2];

        int currentWidth = 0;
        int numLines = 1;

        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];

            if (currentWidth + charWidth > 100) {
                numLines += 1;
                currentWidth = 0;
            }
            currentWidth += charWidth;
        }

        res[0] = numLines;
        res[1] = currentWidth;

        return res;
    }
}