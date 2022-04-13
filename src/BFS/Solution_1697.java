package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 수빈이가 5-10-9-18-17 순으로 가면 4초만에 동생을 찾을 수 있다.
 * 걷기: x + 1, x - 1 // 순간이동: 2*x
 * */
public class Solution_1697 {
    static int[] visit = new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]), target = Integer.parseInt(nums[1]);

        System.out.println(n +", "+target);
        bfs(n, target);
    }

    static void bfs (int n, int target) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            n = q.poll();
            if (n == target) break;

            //visit[n] 에서 visit[n+1] 연산까지 +1번 진행되었다.
            if (n + 1 <= 100000 && visit[n + 1] == 0) {
                q.add(n + 1);
                visit[n + 1] = visit[n] + 1;
            }
            if (n * 2 <= 100000 && visit[n * 2] == 0) {
                q.add(n * 2);
                visit[n * 2] = visit[n] + 1;
            }
            if (n - 1 >= 0 && visit[n - 1] == 0) {
                q.add(n - 1);
                visit[n - 1] = visit[n] + 1;
            }
        }
    }
}
