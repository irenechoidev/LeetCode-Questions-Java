class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0)
            return true;

        int s_pointer = 0;
        int t_pointer = 0;
        while (t_pointer < t.length()) {

            if (s_pointer < s.length() && s.charAt(s_pointer) == t.charAt(t_pointer)) {
                s_pointer += 1;
            }

            t_pointer += 1;
        }

        return s_pointer == s.length();
    }
}