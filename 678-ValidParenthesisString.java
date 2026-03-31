class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftParenStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftParenStack.push(i);
            } else if (c == '*') {
                starStack.push(i);
            } else {
                if (!leftParenStack.isEmpty())
                    leftParenStack.pop();
                else if (!starStack.isEmpty())
                    starStack.pop();
                else {
                    return false;
                }
            }
        }

        while (!leftParenStack.isEmpty() && !starStack.isEmpty()) {
            if (leftParenStack.peek() < starStack.peek()) {
                leftParenStack.pop();
                starStack.pop();
            } else {
                break;
            }
        }
        return leftParenStack.isEmpty();
    }
}