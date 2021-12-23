package queueAndstack;

import java.util.*;

public class MyStack {
    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    public void push(int val) {
        data.add(val);
    }

    public boolean pop() {
        if (isEmpty())
            return false;
        data.remove(data.size()-1);
        return true;
    }

    public int top() {
        if (isEmpty())
            return -1;
        return data.get(data.size()-1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);

        for (int i = 0; i < 4; i++) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }
}
