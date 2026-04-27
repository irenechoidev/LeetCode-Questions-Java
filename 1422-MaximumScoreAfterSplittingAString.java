class Solution {
    public int maxScore(String s) {
        int max = 0;

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1')
                ones += 1;
        }

        int zeros = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1') {
                ones -= 1;

            } else {
                zeros += 1;
            }

            max = Math.max(max, ones + zeros);
        }
        return max;
    }
}