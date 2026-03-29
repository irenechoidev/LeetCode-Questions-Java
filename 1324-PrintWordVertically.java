class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] arr = s.split(" ");

        int maxLength = getMaxLength(arr);

        char[][] board = new char[maxLength][arr.length];

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                String curr = arr[j];
                if (i < curr.length())
                    sb.append(curr.charAt(i));
                else {
                    sb.append(' ');
                }
            }

            res.add(trimTrailing(sb.toString()));
        }
        return res;
    }

    private String trimTrailing(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) != ' ') {
                return str.substring(0, i + 1);
            }
        }
        return "";
    }

    private int getMaxLength(String[] arr) {
        int max = 0;
        for (String s : arr) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }
}