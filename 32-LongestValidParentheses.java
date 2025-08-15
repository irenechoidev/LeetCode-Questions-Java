class Solution {
    public int longestValidParentheses(String s) {

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                res = Math.max(res, i - stack.peek());
            } else {
                stack.push(i);
            }
        }

        return res;
    }
}
