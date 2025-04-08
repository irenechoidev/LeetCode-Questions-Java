class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }

        int idx = 0;
        int direction = 1;

        for (int i = 0; i < s.length(); i++) {
            rows[idx].append(s.charAt(i));

            if (idx == 0) {
                direction = 1;
            } else if (idx == rows.length - 1) {
                direction = -1;
            }

            idx += direction;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows.length; i++) {
            sb.append(rows[i]);
        }

        return sb.toString();
    }
}
