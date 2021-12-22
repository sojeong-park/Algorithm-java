package queueAndstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 방법1. Queue 활용, offer O(1), poll O(1)
 * */
public class LeetCode346 {
    private Queue<Integer> que;
    private int capacity;

    public LeetCode346(int size) {
        que = new LinkedList<>();
        capacity = size;
    }

    public double next(int val) {
        if (que.size() == capacity){
            que.poll();
        }
        que.offer(val);
        int sum = 0;
        for (int k : que) {
            sum += k;
        }
        return (sum*1.0) / que.size();
    }

    public static void main(String[] args) {
        LeetCode346 leetCode346 = new LeetCode346(3);
        leetCode346.next(1);
        leetCode346.next(10);
        leetCode346.next(3);
        leetCode346.next(5);
    }
}
