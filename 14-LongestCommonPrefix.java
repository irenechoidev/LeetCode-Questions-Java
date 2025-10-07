class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int len = Math.min(first.length(), s.length());

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) == s.charAt(j)) {
                    sb.append(first.charAt(j));
                } else {
                    break;
                }
            }
            first = sb.toString();
        }
        return first;
    }
}