class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstOccurrence = new HashMap<>();
        int maxLength = -1;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstOccurrence.containsKey(c)) {
                maxLength = Math.max(maxLength, i - firstOccurrence.get(c) - 1);
            } else {
                firstOccurrence.put(c, i);
            }
        }

        return maxLength;
    }
}