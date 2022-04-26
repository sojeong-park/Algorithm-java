package BFS;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acmicpc.net/problem/13549
 * 숨바꼭질 3
 * 가중치값이 0인 간선이 있어서 단순 bfs로는 풀지 못한다.
 *  -> 0-1 BFS: 가중치가 0인 간선에 연결된 정점은 큐의 맨 뒤가 아닌 맨 앞에 넣는 방법
 * */
public class Solution_13549 {
    static int result = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[100001];
    static int maxSize = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nums = sc.nextLine().split(" ");
        int n = Integer.parseInt(nums[0]); // 수빈이 위치
        int k = Integer.parseInt(nums[1]); // 동생 위치

        bfs_deque(n, k);

        System.out.println(result);
    }

    static void bfs(int n, int target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] nums = queue.poll();
            int num = nums[0];
            int nowTime = nums[1];

            if (num == target) {
                result = Math.min(result, nowTime);
            }

            // x*2
            if (num * 2 <= maxSize && !visited[num * 2]) {
                visited[num * 2] = true;
                queue.offer(new int[]{num * 2, nowTime});
            }

            // x-1
            if (num - 1 >= 0 && !visited[num - 1]) {
                visited[num - 1] = true;
                queue.offer(new int[]{num - 1, nowTime + 1});
            }

            // x+1
            if (num + 1 <= maxSize && !visited[num + 1]) {
                visited[num + 1] = true;
                queue.offer(new int[]{num + 1, nowTime + 1});
            }
        }
    }

    static void bfs_deque(int n, int target) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, 0});
        visited[n] = true;

        while (!queue.isEmpty()) {
            int[] nums = queue.poll();
            int num = nums[0];
            int nowTime = nums[1];

            // Deque를 사용해 가중치가 0인 *2를 가장 앞에 넣을때는 queue안에서 순서가 바뀌기 때문에 방문여부체크를 queue를 뽑을 때 해야한다.
            visited[num] = true;

            if (num == target) {
                result = Math.min(result, nowTime);
            }

            // x-1
            if (num - 1 >= 0 && !visited[num - 1]) {
                queue.add(new int[]{num - 1, nowTime + 1});
            }

            // x+1
            if (num + 1 <= maxSize && !visited[num + 1]) {
                queue.add(new int[]{num + 1, nowTime + 1});
            }

            // x*2
            if (num * 2 <= maxSize && !visited[num * 2]) {
                queue.addFirst(new int[]{num * 2, nowTime});
            }
        }
    }
}
