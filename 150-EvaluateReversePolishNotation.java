class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t : tokens) {
            if (t.equals("+")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 + temp1);
            } else if (t.equals("-")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 - temp1);
            } else if (t.equals("*")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 * temp1);
            } else if (t.equals("/")) {
                int temp1 = stack.pop();
                int temp2 = stack.pop();
                stack.push(temp2 / temp1);
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.peek();
    }
}
