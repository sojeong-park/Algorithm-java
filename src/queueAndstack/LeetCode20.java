package queueAndstack;

import java.util.Stack;

public class LeetCode20 {
    private static Stack<Character> stack = new Stack<>();

    public static boolean isValid(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            } else if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        isValid("(])");
    }
}
