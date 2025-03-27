class Solution {
    int result = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandMiddle(i, i, s);
            expandMiddle(i, i + 1, s);
        }
        return result;
    }

    private void expandMiddle(int start, int end, String s) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            result += 1;
            start -= 1;
            end += 1;
        }
    }
}