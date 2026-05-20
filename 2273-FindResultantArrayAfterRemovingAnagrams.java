class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> res = new ArrayList<>();
        res.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!compare(words[i - 1], words[i])) {
                res.add(words[i]);
            }
        }
        return res;
    }

    private boolean compare(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }

        return true;
    }
}