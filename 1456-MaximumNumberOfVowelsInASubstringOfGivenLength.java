class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isVowel(s.charAt(i)))
                count += 1;

            if (i >= k) {
                if (isVowel(s.charAt(i - k)))
                    count -= 1;
            }

            max = Math.max(max, count);

            if (max == k)
                return max;
        }

        return max;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}