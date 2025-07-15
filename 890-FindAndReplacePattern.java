class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (isMatch(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean isMatch(String s, String p) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> pMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char pChar = p.charAt(i);

            if (sMap.containsKey(sChar) && sMap.get(sChar) != pChar ||
                    pMap.containsKey(pChar) && pMap.get(pChar) != sChar)
                return false;

            sMap.put(sChar, pChar);
            pMap.put(pChar, sChar);
        }
        return true;
    }
}
