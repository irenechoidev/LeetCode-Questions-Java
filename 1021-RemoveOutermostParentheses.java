class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : s.toCharArray()) {

            if (counter == 0)
                counter += 1;

            else if (counter == 1 && c == ')') {
                counter -= 1;

            } else {
                if (c == '(') {
                    sb.append(c);
                    counter += 1;
                } else {
                    sb.append(c);
                    counter -= 1;
                }
            }
        }

        return sb.toString();
    }
}
