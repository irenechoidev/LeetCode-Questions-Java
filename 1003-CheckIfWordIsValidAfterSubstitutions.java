class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'c') {
                if (stack.isEmpty() || stack.peek() != 'b') {
                    return false;
                }
                stack.pop();

                if (stack.isEmpty() || stack.peek() != 'a') {
                    return false;
                }
                stack.pop();

            } else {
                stack.push(c);
            }

        }
        return stack.isEmpty();
    }
}