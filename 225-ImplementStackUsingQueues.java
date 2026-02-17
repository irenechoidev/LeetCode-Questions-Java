class MyStack {
    Queue<Integer> mainQueue;
    Queue<Integer> tempQueue;

    public MyStack() {
        mainQueue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        while (!mainQueue.isEmpty()) {
            tempQueue.add(mainQueue.remove());
        }
        mainQueue.add(x);
        while (!tempQueue.isEmpty()) {
            mainQueue.add(tempQueue.remove());
        }
    }

    public int pop() {
        return mainQueue.remove();
    }

    public int top() {
        return mainQueue.peek();
    }

    public boolean empty() {
        return mainQueue.isEmpty();
    }
}