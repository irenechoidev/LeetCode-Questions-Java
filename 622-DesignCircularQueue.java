class MyCircularQueue {
    int[] queue;
    int front = -1;
    int rear = -1;

    public MyCircularQueue(int k) {
        queue = new int[k];
    }

    public boolean enQueue(int value) {
        // case 1: queue is full
        if (isFull())
            return false;

        // case 2: one item - queue is empty(make one item queue)
        else if (isEmpty()) {
            front += 1;
            rear += 1;
            queue[rear] = value;

            // case 3: regular case
        } else {
            rear += 1;
            queue[rear % queue.length] = value;
        }

        return true;
    }

    public boolean deQueue() {

        // case 1: queue is empty(nothing to dequeue)
        if (isEmpty())
            return false;

        // case 2: one item - only one item in the queue(make to empty)
        if (front == rear) {
            front = -1;
            rear = -1;

            // case 3: regular case
        } else {
            front += 1;
        }
        return true;
    }

    public int Front() {
        return front == -1 ? -1 : queue[front % queue.length];
    }

    public int Rear() {
        return rear == -1 ? -1 : queue[rear % queue.length];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return !isEmpty()
                // next to the rear should be front
                && (rear + 1) % queue.length == (front % queue.length);
    }
}
