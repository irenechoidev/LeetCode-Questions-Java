class Solution {
    public int appendCharacters(String s, String t) {
        int s_pointer = 0;
        int t_pointer = 0;

        while (s_pointer < s.length()) {
            if (t_pointer < t.length() && t.charAt(t_pointer) == s.charAt(s_pointer)) {
                s_pointer += 1;
                t_pointer += 1;
            } else {
                s_pointer += 1;
            }
        }
        return t.length() - t_pointer;
    }
}