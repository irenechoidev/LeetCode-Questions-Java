class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();

        Map<Character, String> map = getCodeMap();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray()) {
                sb.append(map.get(c));
            }
            set.add(sb.toString());
        }

        return set.size();
    }

    private Map<Character, String> getCodeMap() {
        Map<Character, String> map = new HashMap<>();

        String letters = "abcdefghijklmnopqrstuvwxyz";
        String[] code = new String[] {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
                ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        for (int i = 0; i < code.length; i++) {
            map.put(letters.charAt(i), code[i]);
        }
        return map;
    }
}
