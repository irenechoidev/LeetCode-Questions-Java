class Solution {
    public String sortString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }

            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[i] != 0) {
                    sb.append((char) (i + 'a'));
                    arr[i]--;
                }
            }
        }
        return sb.toString();
    }
}