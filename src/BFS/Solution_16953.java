package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/16953
 * A → B
 * */
class PairCount {
    long x;
    int count;

    public PairCount(long x, int count) {
        this.x = x;
        this.count = count;
    }
}
public class Solution_16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nums = sc.nextLine().split(" ");
        long n = Long.parseLong(nums[0]);
        long target = Long.parseLong(nums[1]);

        bfs(n, target);
    }

    static void bfs (long n, long target) {
        Queue<PairCount> queue = new LinkedList<>();
        queue.offer(new PairCount(n, 0));

        while (!queue.isEmpty()) {
            PairCount k = queue.poll();
            if (k.x == target) {
                System.out.println(k.count + 1);
                return;
            }

            // 2를 곱한다.
            if (k.x * 2 <= target ) {
                queue.offer(new PairCount(k.x * 2, k.count + 1));
            }

            // 가장 오른쪽에 1을 추가한다. 1->11, 12 ->121
            long x = 10 * k.x + 1;
            if (x <= target) {
                queue.offer(new PairCount(x, k.count + 1));
            }
        }
        System.out.println(-1);
    }
}
