class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>();
        String vowel = "aeiouAEIOU";
        for (char c : vowel.toCharArray()) {
            set.add(c);
        }

        int aCount = 0;
        int bCount = 0;
        int n = s.length() / 2;
        for (int i = 0; i < n; i++) {
            if (set.contains(s.charAt(i)))
                aCount += 1;
        }
        for (int i = n; i < s.length(); i++) {
            if (set.contains(s.charAt(i)))
                bCount += 1;
        }

        return aCount == bCount;
    }
}