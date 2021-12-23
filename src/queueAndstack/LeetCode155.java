package queueAndstack;

import java.util.*;

public class LeetCode155 {
    /**
     * stack의 FIFO 대로 push와 pop을 하면서 가장 작은값을 반환하는 getMin()메소드도 구현한다.
     * stack의 자료구조에 [1,2] 크기가 2인 배열 형식으로 저장한다.
     *  0번째 인덱스에는 입력값, 1번쨰 인덱스에는 최소값을 유지한다.
     * */
    private Stack<int[]> stack = new Stack<>();
    public LeetCode155() {

    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(new int[]{val, val});
            return;
        }
        int currentMin = stack.peek()[1];
        stack.push(new int[]{val, Math.min(currentMin, val)});
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek()[0];
    }

    public int getMin() {
        return stack.peek()[1];
    }

    public static void main(String[] args) {
        LeetCode155 minStack = new LeetCode155();
        minStack.push(2);
        minStack.push(0);
        minStack.push(3);
        minStack.push(0);

        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
