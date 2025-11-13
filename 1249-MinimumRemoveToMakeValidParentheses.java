class Solution {
    public String minRemoveToMakeValid(String s) {
        int open = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open += 1;
            } else if (c == ')') {
                if (open == 0)
                    continue;
                open -= 1;
            }

            sb.append(c);
        }

        StringBuilder res = new StringBuilder();
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (c == '(' && open > 0) {
                open -= 1;
            } else {
                res.append(c);
            }
        }

        return res.reverse().toString();
    }
}
