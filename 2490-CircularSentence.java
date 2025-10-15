public class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        int n = words.length;

        for (int i = 0; i < n; i++) {

            int nextWord = (i - 1 + n) % n;

            char start = words[i].charAt(0);
            char end = words[nextWord].charAt(words[nextWord].length() - 1);

            if (start != end) {
                return false;
            }

        }

        return true;
    }
}