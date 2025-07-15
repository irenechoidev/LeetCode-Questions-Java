class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (!Character.isLetter(arr[start])) {
                start += 1;
            } else if (!Character.isLetter(arr[end])) {
                end -= 1;
            } else {
                char temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start += 1;
                end -= 1;
            }
        }
        return String.valueOf(arr);
    }
}
