class Solution {
    public String minWindow(String s, String t) {
        int minStart = -1;
        int minEnd = -1;
        int minLen = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int count = t.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        while (end < s.length()) {

            char endChar = s.charAt(end);
            if (map.containsKey(endChar)) {
                map.put(endChar, map.get(endChar) - 1);
                if (map.get(endChar) >= 0) {
                    count -= 1;
                }
            }
            end += 1;

            while (count == 0) {

                if (end - start < minLen) {
                    minLen = end - start;
                    minStart = start;
                    minEnd = end;
                }

                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count += 1;
                    }
                }
                start += 1;
            }
        }

        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(minStart, minEnd);
    }
}