class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] freq = new int[3];

        int start = 0;
        int end = 0;
        while (end < s.length()) {

            char endChar = s.charAt(end);
            freq[endChar - 'a']++;

            while (allThree(freq)) {

                res += s.length() - end;

                char startChar = s.charAt(start);
                freq[startChar - 'a']--;
                start += 1;
            }
            end += 1;
        }
        return res;
    }

    private boolean allThree(int[] freq) {
        return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
    }
}