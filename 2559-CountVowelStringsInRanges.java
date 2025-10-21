class Solution {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];

        String vowel = "aeiou";
        HashSet<Character> set = new HashSet<>();
        for (char c : vowel.toCharArray()) {
            set.add(c);
        }

        int[] prefixSum = new int[words.length];
        int sum = 0;
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];

            if (set.contains(currWord.charAt(0)) &&
                    set.contains(currWord.charAt(currWord.length() - 1))) {
                sum += 1;
            }

            prefixSum[i] = sum;
        }

        for (int i = 0; i < queries.length; i++) {
            int[] currQuery = queries[i];
            int left = currQuery[0];
            int right = currQuery[1];
            ans[i] = prefixSum[right] -
                    (left == 0 ? 0 : prefixSum[left - 1]);
        }

        return ans;
    }
}