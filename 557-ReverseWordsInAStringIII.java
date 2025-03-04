class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {

            if (i > 0)
                sb.append(" ");

            String word = words[i];
            sb.append(reverse(word));
        }

        return sb.toString();
    }

    private String reverse(String word) {
        char[] arr = word.toCharArray();
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start += 1;
            end -= 1;
        }

        return String.valueOf(arr);
    }
}