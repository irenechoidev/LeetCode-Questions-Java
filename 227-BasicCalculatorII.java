class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(count);
                } else if (sign == '-') {
                    stack.push(-count);
                } else if (sign == '*') {
                    stack.push(stack.pop() * count);
                } else if (sign == '/') {
                    stack.push(stack.pop() / count);
                }
                count = 0;
                sign = c;
            }

        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}