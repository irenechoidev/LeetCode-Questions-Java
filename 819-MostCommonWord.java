class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        for (String b : banned)
            set.add(b);

        Map<String, Integer> map = new HashMap<>();
        String[] strs = paragraph
                .replaceAll("[^a-zA-Z]", " ")
                .toLowerCase()
                .split("\\s+");

        for (String s : strs) {
            if (!set.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int max = 0;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}