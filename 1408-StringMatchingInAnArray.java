public class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length;
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (set.contains(words[j]))
                    continue;

                if (i != j && strContains(words[i], words[j])) {
                    res.add(words[j]);
                    set.add(words[j]);
                }
            }
        }

        return res;
    }

    private boolean strContains(String str, String subStr) {
        for (int i = 0; i < str.length(); i++) {
            int ptr = i;
            boolean isFound = true;

            for (int j = 0; j < subStr.length(); j++) {
                if (ptr < str.length() && str.charAt(ptr) == subStr.charAt(j)) {
                    ptr += 1;
                } else {
                    isFound = false;
                    break;
                }
            }

            if (isFound)
                return true;
        }

        return false;
    }
}