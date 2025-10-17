class Solution {
    public boolean makeEqual(String[] words) {
        int[] arr = new int[26];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                arr[c - 'a']++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % words.length != 0)
                return false;
        }

        return true;
    }
}