class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String result = "";
        int minLen = Integer.MAX_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (String word : words) {
            Map<Character, Integer> tempMap = new HashMap<>(map);

            for (char c : word.toCharArray()) {
                if (tempMap.containsKey(c) && tempMap.get(c) > 0) {
                    tempMap.put(c, tempMap.get(c) - 1);
                }
            }

            boolean isComplete = true;
            for (int count : tempMap.values()) {
                if (count > 0) {
                    isComplete = false;
                    break;
                }
            }

            if (isComplete && word.length() < minLen) {
                minLen = word.length();
                result = word;
            }
        }
        return result;
    }
}
