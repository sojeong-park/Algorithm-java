package queueAndstack;

public class CircularQueue2 {
    private int[] queue;
    private int front;
    private int capacity;
    private int count;

    public CircularQueue2(int k) {
        this.queue = new int[k];
        this.capacity = k;
        this.front = 0;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;
        int index = (this.front + this.count) % this.capacity;
        queue[index] = value;
        this.count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        this.front = (this.front + 1) % this.capacity;
        this.count--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return this.queue[this.front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        int index = (this.front + this.count - 1) % this.capacity;
        return queue[index];
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public boolean isFull() {
        return this.count == this.capacity;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);

        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);

        circularQueue.Rear();
        circularQueue.isFull();
        circularQueue.deQueue();
        circularQueue.enQueue(4);
        circularQueue.Rear();
    }
}
