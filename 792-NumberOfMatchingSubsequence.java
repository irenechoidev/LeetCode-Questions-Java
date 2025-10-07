class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : map.keySet()) {

            int s_pointer = 0;
            int w_pointer = 0;

            while (s_pointer < s.length()) {
                if (w_pointer >= word.length()) {
                    break;
                } else if (s.charAt(s_pointer) == word.charAt(w_pointer)) {
                    s_pointer += 1;
                    w_pointer += 1;
                } else {
                    s_pointer += 1;
                }
            }

            result += (w_pointer == word.length()) ? map.get(word) : 0;
        }

        return result;
    }
}