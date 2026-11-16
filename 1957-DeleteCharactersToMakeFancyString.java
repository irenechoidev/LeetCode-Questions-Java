class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int end = 0;

        while (end < s.length()) {

            int start = end;
            while (end < s.length() && s.charAt(start) == s.charAt(end)) {
                end += 1;
            }

            int keep = Math.min(2, end - start);
            for (int i = 0; i < keep; i++) {
                sb.append(s.charAt(start));
            }

            start = end;
        }

        return sb.toString();
    }
}
