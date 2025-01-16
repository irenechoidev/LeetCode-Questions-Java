class Solution {
    public List<String> commonChars(String[] words) {
        List<String> result = new ArrayList<>();

        int n = words.length;
        int[] arr = new int[26];

        String firstWord = words[0];
        for (int i = 0; i < firstWord.length(); i++) {
            arr[firstWord.charAt(i) - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] temp = new int[26];
            for (char c : words[i].toCharArray()) {
                if (arr[c - 'a'] == 0)
                    continue;
                else {
                    temp[c - 'a']++;
                    arr[c - 'a']--;
                }
            }
            arr = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > 0) {
                char value = (char) (i + 'a');
                result.add(String.valueOf(value));
                arr[i]--;
            }
        }

        return result;
    }
}
