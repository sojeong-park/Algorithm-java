package queueAndstack;

import java.util.Stack;

public class LeetCode150 {
    /**
     * 계산기 문제
     * 숫자와 +, -, *, / 연산이 입력값으로 들어온다.
     * ex) 입력: ["2","1","+","3","*"] -> ((2 + 1) * 3) = 9
     *     출력: 9
     * tokens 배열 순회
     *  - 숫자일경우 stack push
     *  - 연산자일 경우 숫자 2개 pop 하여 계산 후 다시 stack push
     * */
    private static Stack<Integer> stack = new Stack<>();

    public  static int evalRPN(String[] tokens) {
        for (String token : tokens) {
            char c = token.charAt(0);

            if (Character.isDigit(c) || token.length()>1) {
                stack.push(Integer.parseInt(token));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;

                switch (c) {
                    case '+':
                        result = num2 + num1;
                        break;
                    case '-':
                        result = num2 - num1;
                        break;
                    case '*':
                        result = num2 * num1;
                        break;
                    case '/':
                        result = num2 / num1;
                        break;
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
    }
}
