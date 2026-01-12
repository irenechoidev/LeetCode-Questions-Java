class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int sign = 1;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '+') {
                res += count * sign;
                count = 0;
                sign = 1;
            } else if (c == '-') {
                res += count * sign;
                count = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += count * sign;
                count = 0;
                sign = 1;

                res *= stack.pop();
                res += stack.pop();
            }
        }

        if (count != 0) {
            res += count * sign;
        }
        return res;
    }
}