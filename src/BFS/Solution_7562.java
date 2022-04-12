package BFS;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.acmicpc.net/problem/7562
 * 나이트의 이동
 * */
public class Solution_7562 {
    static int[] dx = {-2,-1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {-1,-2, -2 ,-1, 1, 2, 2, 1};
    static boolean[][] visited;
    static int[][] arr;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // test case 개수
        for (int i = 0; i < t; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N][N];
            visited = new boolean[N][N];

            String[] night = br.readLine().split(" "); // 현재 나이트 위치
            String[] target = br.readLine().split(" "); // 목표 위치

            int nightX = Integer.parseInt(night[0]), nightY = Integer.parseInt(night[1]);
            int targetX = Integer.parseInt(target[0]), targetY = Integer.parseInt(target[1]);

            bfs(nightX, nightY, targetX, targetY);
            System.out.println(arr[targetX][targetY]);
        }
    }

    static void bfs(int a, int b, int targetX, int targetY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a, b));
        visited[a][b] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int x = p.x;
            int y = p.y;
            if (x == targetX && y == targetY) break;
            for (int i = 0; i < 8; i++) {
                int kx = x + dx[i];
                int ky = y + dy[i];
                if (kx >= 0 && ky >= 0 && kx < N && ky < N) {
                    if (arr[kx][ky] == 0) {
                        arr[kx][ky] = arr[x][y] + 1;
                        queue.offer(new Point(kx, ky));
                    }
                }
            }
        }
    }
}
