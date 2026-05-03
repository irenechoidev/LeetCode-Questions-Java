class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int res = 0;

        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }

        String[] str = text.split(" ");
        for (String s : str) {
            boolean isWord = true;
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    isWord = false;
                    break;
                }
            }
            if (isWord)
                res += 1;
        }
        return res;
    }
}