class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));

            if (stack.size() >= part.length() && match(stack, part, part.length())) {
                for (int j = 0; j < part.length(); j++) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    private boolean match(
            Stack<Character> stack,
            String part,
            int len) {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stack);
        for (int i = len - 1; i >= 0; i--) {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) {
                return false;
            }
            temp.pop();
        }
        return true;

    }
}