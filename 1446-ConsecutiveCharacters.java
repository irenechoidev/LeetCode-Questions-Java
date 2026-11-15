class Solution {
    public int maxPower(String s) {
        int count = 1;
        int max = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                count += 1;
            } else {
                count = 1;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}