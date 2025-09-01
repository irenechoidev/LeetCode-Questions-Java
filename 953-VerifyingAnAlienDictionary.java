class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i], map)) {
                return false;
            }
        }
        return true;
    }

    private boolean compare(String s1, String s2, Map<Character, Integer> map) {
        int len1 = s1.length();
        int len2 = s2.length();
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                return map.get(c1) < map.get(c2);
            }
        }
        return len1 <= len2;
    }
}
