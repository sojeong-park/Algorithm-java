package Kakao;

import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 * 크레인 인형뽑기 게임
 * 난이도: Level1
 * 2차원 배열 탐색과 스택 활용
 * */
public class Solution3 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            move -= 1;
            for (int i = 0; i < board[move].length; i++) {
                if (board[i][move] != 0) {
                    if (!stack.empty()) {
                        if (stack.peek() == board[i][move]) {
                            stack.pop();
                            answer += 2;
                        } else {
                            stack.push(board[i][move]);
                        }
                    } else {
                        stack.push(board[i][move]);
                    }
                    board[i][move] = 0;
                    break;
                }
            }
        }
        System.out.println(stack);
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}},
                new int[]{1,5,3,5,1,2,1,4});

    }
}
