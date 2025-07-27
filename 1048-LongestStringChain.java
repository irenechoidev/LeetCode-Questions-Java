class Solution {
    public int longestStrChain(String[] words) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        for (String word : words) {
            map.put(word, 1);

            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(word);
                sb.deleteCharAt(i);
                String s = sb.toString();

                if (map.containsKey(s) && map.get(s) + 1 > map.get(word)) {
                    map.put(word, map.get(s) + 1);
                }
            }

            res = Math.max(res, map.get(word));
        }

        return res;
    }
}