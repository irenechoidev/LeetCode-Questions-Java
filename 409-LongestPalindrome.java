class Solution {
    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int oddFrequencyCount = 0;
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1)
                oddFrequencyCount += 1;
        }

        return oddFrequencyCount > 0 ? s.length() - oddFrequencyCount + 1 : s.length();

    }
}