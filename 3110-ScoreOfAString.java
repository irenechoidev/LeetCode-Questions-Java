class Solution {
    public int scoreOfString(String s) {

        int score = 0;

        for (int i = 1; i < s.length(); i++) {

            int prev = s.charAt(i - 1) - 'a';
            int curr = s.charAt(i) - 'a';

            score += Math.abs(prev - curr);
        }

        return score;
    }
}