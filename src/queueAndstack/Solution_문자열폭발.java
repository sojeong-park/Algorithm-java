package queueAndstack;

import java.util.*;

/**
 * https://www.acmicpc.net/problem/9935
 * 문자열 폭발
 * */
public class Solution_문자열폭발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String target = sc.nextLine();
        int targetSize = target.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));

            if (stack.size() >= targetSize) {
                boolean flag = true;
                for (int j = 0; j < targetSize; j++) {
                    if (stack.get(stack.size() - targetSize + j) != target.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    for (int k = 0; k < targetSize; k++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb.toString());
        }
    }
}
