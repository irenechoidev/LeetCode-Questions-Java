class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }

        int result = 0;
        for (String word : words) {
            boolean found = true;
            for (int j = 0; j < word.length(); j++) {
                if (!set.contains(word.charAt(j))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                result += 1;
            }
        }
        return result;
    }
}