class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return makeString(word1).equals(makeString(word2));
    }

    private String makeString(String[] word) {
        StringBuilder sb = new StringBuilder();
        for (String s : word) {
            for (char c : s.toCharArray()) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}