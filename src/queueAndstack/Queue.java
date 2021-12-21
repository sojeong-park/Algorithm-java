package queueAndstack;

import java.util.ArrayList;
import java.util.List;

public class Queue {
    private List<Integer> data;
    private int head;

    public Queue() {
        data = new ArrayList<>();
        head = 0;
    }

    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;
        head++;
        return true;
    }

    public int front() {
        return data.get(head);
    }

    public boolean isEmpty() {
        return head >= data.size();
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enQueue(5);
        q.enQueue(7);

        System.out.println(q.front()); // 5

        q.deQueue(); // head = 1

        System.out.println(q.front()); // 7
    }
}
