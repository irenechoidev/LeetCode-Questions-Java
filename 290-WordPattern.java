class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length)
            return false;

        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> stringMap = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = sArr[i];

            if (stringMap.containsKey(word) && !stringMap.get(word).equals(c))
                return false;
            if (charMap.containsKey(c) && !charMap.get(c).equals(word))
                return false;

            charMap.put(c, word);
            stringMap.put(word, c);
        }
        return true;
    }
}
