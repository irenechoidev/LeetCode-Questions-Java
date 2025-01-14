class MinStack {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
        dataStack.push(val);
    }

    public void pop() {
        if (minStack.peek().equals(dataStack.peek())) {
            minStack.pop();
        }
        dataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}