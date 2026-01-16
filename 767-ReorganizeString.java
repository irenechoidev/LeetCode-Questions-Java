class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] counts = new int[26];
        int maxCount = 0;
        char maxChar = ' ';

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
            if (counts[c - 'a'] > maxCount) {
                maxCount = counts[c - 'a'];
                maxChar = c;
            }
        }

        if (maxCount > (n + 1) / 2)
            return "";

        char[] res = new char[n];
        int idx = 0;
        while (counts[maxChar - 'a'] > 0) {
            res[idx] = maxChar;
            idx += 2;
            counts[maxChar - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            while (counts[i] > 0) {
                if (idx >= n) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                counts[i]--;
            }
        }

        return String.valueOf(res);
    }
}