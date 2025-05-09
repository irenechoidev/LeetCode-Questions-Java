class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>(map);
            boolean isWord = true;

            for (char c : word.toCharArray()) {
                if (!tempMap.containsKey(c) || tempMap.get(c) == 0) {
                    isWord = false;
                    break;
                }
                tempMap.put(c, tempMap.get(c) - 1);
            }

            if (isWord) {
                result += word.length();
            }
        }

        return result;
    }
}
