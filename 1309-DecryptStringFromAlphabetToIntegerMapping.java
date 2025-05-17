class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = s.length() - 1;

        while (idx >= 0) {
            if (idx >= 2 && s.charAt(idx) == '#') {
                int num = (s.charAt(idx - 2) - '0') * 10 + (s.charAt(idx - 1) - '0');
                sb.append((char) ('a' + num - 1));
                idx -= 3;
            } else {
                int num = s.charAt(idx) - '0';
                sb.append((char) ('a' + num - 1));
                idx--;
            }
        }

        return sb.reverse().toString();
    }
}