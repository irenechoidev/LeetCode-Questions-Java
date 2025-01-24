class Solution {
    public int lengthOfLongestSubstring(String s) {

        int result = 0;

        int start = 0;
        int end = 0;

        Set<Character> set = new HashSet<>();
        while (end < s.length()) {

            if (!set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                end += 1;

                result = Math.max(result, set.size());

            } else {
                set.remove(s.charAt(start));
                start += 1;
            }
        }

        return result;
    }
}
