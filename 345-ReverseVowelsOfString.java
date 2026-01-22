class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            set.add(c);
        }

        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            char startChar = chars[start];
            char endChar = chars[end];
            while (start < end && !set.contains(startChar)) {
                start += 1;
                startChar = chars[start];
            }
            while (start < end && !set.contains(endChar)) {
                end -= 1;
                endChar = chars[end];
            }
            if (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start += 1;
                end -= 1;
            }
        }
        return String.valueOf(chars);
    }
}
