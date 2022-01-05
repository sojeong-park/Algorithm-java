package recursion;

import java.util.List;

/**
 * https://www.acmicpc.net/problem/15649
 * 문제: 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
 *      1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 * 입력: 3 1
 * 출력: 1
 *      2
 *      3
 * */
public class n과m1 {
    public static int[] result = new int[10];
    public static boolean[] visit = new boolean[10];
    public static void solution(int index, int n, int m) {
        if (index == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(result[i]);
                if (i != m - 1) System.out.print(' ');
            }
            System.out.println();
        }
        for (int i = 1; i <= n; i++) {
            if (visit[i]) continue;
            visit[i] = true;
            result[index] = i;
            solution(index + 1, n, m);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int m = 2;
        solution(0, n, m);
    }
}
