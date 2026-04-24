class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];

        int start = 0;
        int end = s.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'D') {
                result[i] = end;
                end -= 1;
            } else if (s.charAt(i) == 'I') {
                result[i] = start;
                start += 1;
            }
        }

        result[s.length()] = start;
        // result[s.length()] = end;

        return result;
    }
}