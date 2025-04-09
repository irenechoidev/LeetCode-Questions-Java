class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> maxMap = new HashMap<>();

        for (String s : words2) {

            Map<Character, Integer> wordMap = makeMap(s);
            for (char c : s.toCharArray()) {
                int maxMapVal = maxMap.getOrDefault(c, 0);
                int wordMapVal = wordMap.getOrDefault(c, 0);

                maxMap.put(c, Math.max(maxMapVal, wordMapVal));
            }
        }

        for (String s : words1) {

            boolean addToTrue = true;
            Map<Character, Integer> wordMap = makeMap(s);
            for (char c : s.toCharArray()) {
                for (Map.Entry<Character, Integer> entry : maxMap.entrySet()) {
                    int count = wordMap.getOrDefault(entry.getKey(), -1);
                    if (entry.getValue() > count) {
                        addToTrue = false;
                        break;
                    }
                }
            }

            if (addToTrue)
                result.add(s);
        }
        return result;
    }

    private Map<Character, Integer> makeMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
