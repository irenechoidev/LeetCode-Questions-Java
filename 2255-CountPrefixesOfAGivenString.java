class Solution {
    public int countPrefixes(String[] words, String s) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            String prefix = sb.append(s.charAt(i)).toString();
            if (map.containsKey(prefix)) {
                res += map.get(prefix);
            }
        }
        return res;
    }
}