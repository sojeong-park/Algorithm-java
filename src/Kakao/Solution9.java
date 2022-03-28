package Kakao;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 * 수식 최대화
 * 난이도: Level 2
 * */
public class Solution9 {
    /**
     * 연산자 3개(+, -, *)가 주어지는데 우선순위를 정해서 계산한다
     * 순열을 이용한 연산자 3개 완전탐색 3! = 6, 최대 6번의 연산을 하면 되므로 모두 계산하여 최대값 구하기
     * */
    private static long answer = Long.MIN_VALUE;
    private static boolean[] visited = new boolean[3];
    private static Character[] operations = {'+', '-', '*'};
    private static Character[] priority = new Character[3];
    private static List<Long> numList = new ArrayList<>();
    private static List<Character> opList = new ArrayList<>();

    public static long solution(String expression) {
        //1. String 으로 들어온 숫자와 연산자 분리해 각 배열에 저장하기
        long currentNumber = 0;
        for (char ex : expression.toCharArray()) {
            if (Character.isDigit(ex)) {
                currentNumber = (currentNumber * 10) + (ex - '0');
            } else {
                numList.add(currentNumber);
                currentNumber = 0;
                opList.add(ex);
            }
        }
        //마지막 숫자 input
        numList.add(currentNumber);

        //2. 연산자 우선순위 구하고 계산하기
        permutation(3, 0);

        return answer;
    }

    public static void permutation(int target, int depth) {
        if (depth == target) {
            calculation();
        }

        for (int i = 0; i < target; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = operations[i];
                permutation(target, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculation() {
        List<Long> nums = new ArrayList<>();
        nums.addAll(numList);

        List<Character> opers = new ArrayList<>();
        opers.addAll(opList);

        for (int i = 0; i < priority.length; i++) {
            char op = priority[i];
            for (int j = 0; j < opers.size(); j++) {
                if (opers.get(j) == op) {
                    long n1 = nums.get(j);
                    long n2 = nums.get(j+1);
                    long ans = cal(n1, n2, op);

                    nums.remove(j+1);
                    nums.remove(j);
                    opers.remove(j);

                    nums.add(j, ans);

                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(nums.get(0)));
    }

    public static long cal(long num1, long num2, char op) {
        long result = 0;
        switch (op) {
            case '+' :
                result = num1 + num2;
                break;
            case '-' :
                result = num1 - num2;
                break;
            case '*' :
                result = num1 * num2;
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }
}
