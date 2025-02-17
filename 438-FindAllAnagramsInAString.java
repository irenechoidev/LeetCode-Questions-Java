class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        int count = p.length();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
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

            while ((end - start + 1) >= p.length()) {
                if (count == 0)
                    result.add(start);

                char startChar = s.charAt(start);
                if (map.containsKey(startChar)) {
                    map.put(startChar, map.get(startChar) + 1);
                    if (map.get(startChar) > 0) {
                        count += 1;
                    }
                }
                start += 1;
            }

            end += 1;
        }
        return result;
    }
}
