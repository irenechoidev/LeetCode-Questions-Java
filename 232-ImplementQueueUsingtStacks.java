class MyQueue {
    Stack<Integer> mainStack;
    Stack<Integer> tempStack;

    public MyQueue() {
        mainStack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void push(int x) {
        while (!mainStack.isEmpty()) {
            tempStack.push(mainStack.pop());
        }
        mainStack.push(x);
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }
    }

    public int pop() {
        return mainStack.pop();
    }

    public int peek() {
        return mainStack.peek();
    }

    public boolean empty() {
        return mainStack.isEmpty();
    }
}