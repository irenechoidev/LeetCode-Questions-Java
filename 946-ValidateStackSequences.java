class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        int popIdx = 0;
        while (pushIdx < pushed.length && popIdx < popped.length) {

            stack.push(pushed[pushIdx]);
            pushIdx += 1;

            while (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx += 1;
            }

        }

        return stack.isEmpty();
    }
}
