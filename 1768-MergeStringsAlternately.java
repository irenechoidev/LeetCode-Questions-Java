class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1_pointer = 0;
        int word2_pointer = 0;
        StringBuilder sb = new StringBuilder();
        while (word1_pointer < word1.length() || word2_pointer < word2.length()) {
            if (word1_pointer < word1.length()) {
                sb.append(word1.charAt(word1_pointer));
                word1_pointer += 1;
            }

            if (word2_pointer < word2.length()) {
                sb.append(word2.charAt(word2_pointer));
                word2_pointer += 1;
            }
        }
        return sb.toString();
    }
}
