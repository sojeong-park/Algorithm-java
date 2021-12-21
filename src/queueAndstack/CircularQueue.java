package queueAndstack;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 622. Design Circular Queue Medium
 *  * Your MyCircularQueue object will be instantiated and called as such:
 *  * MyCircularQueue obj = new MyCircularQueue(k);
 *  * boolean param_1 = obj.enQueue(value);
 *  * boolean param_2 = obj.deQueue();
 *  * int param_3 = obj.Front();
 *  * int param_4 = obj.Rear();
 *  * boolean param_5 = obj.isEmpty();
 *  * boolean param_6 = obj.isFull();
 * */
public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;

    public CircularQueue(int k) {
        queue = new int[k];
        size = k;
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        if (isEmpty()) {
            rear = 0;
        }
        queue[rear] = value;
        rear = (rear + 1) % size;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
            return true;
        }
        front = (front + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return queue[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return queue[rear];
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return ((rear + 1) % size) == front;
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
